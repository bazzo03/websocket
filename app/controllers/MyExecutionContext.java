package controllers;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

import javax.inject.Inject;

public class MyExecutionContext extends CustomExecutionContext {

    @Inject
    public MyExecutionContext(ActorSystem actorSystem) {
        // uses a custom thread pool defined in application.conf
        super(actorSystem, "my.dispatcher");
    }
}