package com.furryfaust.patterns.multiplayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;

public class Multiplayer {

    public final String api = "http://patterns.furryfaust.com/api/";
    public String usernameStore, passwordStore;
    public String temp;

    public Multiplayer() {
        usernameStore = passwordStore = temp = "";
    }

    public void checkConnection(String username, String password) {
        temp = "";

        Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.GET);
        request.setUrl(api + "auth.php?username=" + username + "&password="
                + password);
        Gdx.net.sendHttpRequest(request, new ResponseListener());
    }

    public void createAccount(String username, String password) {
        temp = "";

        Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.GET);
        request.setUrl(api + "createaccount.php?username=" + username + "&password="
                + password);


        Gdx.net.sendHttpRequest(request, new ResponseListener());
    }

    public void requestGames(String username, String password) {
        temp = "";

        Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.GET);
        request.setUrl(api + "games.php?username=" + username + "&password="
                + password);

        Gdx.net.sendHttpRequest(request, new ResponseListener());
    }

    public void infoGames(String username, String password, String ids) {
        temp = "";

        Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.GET);
        request.setUrl(api + "game.php?username=" + username + "&password="
                + password + "&gameid=" + ids);

        Gdx.net.sendHttpRequest(request, new ResponseListener());
    }

    public void startGame(String username, String password, String id) {
        temp = "";

        Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.GET);
        request.setUrl(api + "startgame.php?username=" + username + "&password="
                + password + "&gameid=" + id);

        Gdx.net.sendHttpRequest(request, new ResponseListener());
    }

    public void submitGame(String username, String password, String id, String moves) {
        temp = "";

        Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.GET);
        request.setUrl(api + "submitgame.php?username=" + username + "&password="
                + password + "&gameid=" + id + "&moves=" + moves);

        Gdx.net.sendHttpRequest(request, new ResponseListener());
    }

    class ResponseListener implements Net.HttpResponseListener {

        @Override
        public void handleHttpResponse(Net.HttpResponse httpResponse) {
            temp = httpResponse.getResultAsString();
        }

        @Override
        public void failed(Throwable t) {
            temp = "false - connection failed";
        }

        @Override
        public void cancelled() {
            temp = "";
        }
    }

}
