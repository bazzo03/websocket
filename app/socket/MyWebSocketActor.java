package socket;
import akka.actor.*;


public class MyWebSocketActor extends AbstractActor {

    public static Props props(ActorRef out) {
        return Props.create(MyWebSocketActor.class, out);
    }

    private final ActorRef out;

    public MyWebSocketActor(ActorRef out) {
        this.out = out;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    System.out.println(message);
                    out.tell("I received your message: " + message, self());
                    while (true) {
                        System.out.println("in loop");
                        sender().tell("received", self());
                    }

                        }

                )
                .build();
    }

 /*   @Override
    public Receive receive() {
        return receiveBuilder().match(String.class, message ->
                {
                    while (true) {
                        out ! message;
                        //out.tell("Im sending this string", self());
                    }
                }
                ).build();
    }*/
}
