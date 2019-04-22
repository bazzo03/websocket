package controllers;

import play.libs.streams.ActorFlow;
import play.mvc.*;
import akka.actor.*;
import akka.stream.*;
import socket.MyWebSocketActor;

import javax.inject.Inject;

public class HomeController extends Controller {

    private final ActorSystem actorSystem;
    private final Materializer materializer;

    @Inject
    public HomeController(ActorSystem actorSystem, Materializer materializer) {
        this.actorSystem = actorSystem;
        this.materializer = materializer;
    }

    public WebSocket socket() {
        return WebSocket.Json.accept(
                request -> ActorFlow.actorRef(MyWebSocketActor::props, actorSystem, materializer));
    }
}