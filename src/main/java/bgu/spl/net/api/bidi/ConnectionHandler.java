package bgu.spl.net.api.bidi;

import java.io.Closeable;

public interface ConnectionHandler<T> extends Closeable, Runnable {

    void send(T msg);

}
