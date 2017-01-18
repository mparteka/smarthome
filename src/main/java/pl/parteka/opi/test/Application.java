package pl.parteka.opi.test;


import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import io.moquette.parser.proto.messages.AbstractMessage;
import io.moquette.parser.proto.messages.PublishMessage;
import io.moquette.server.Server;
import io.moquette.server.config.ClasspathResourceLoader;
import io.moquette.server.config.IConfig;
import io.moquette.server.config.IResourceLoader;
import io.moquette.server.config.ResourceLoaderConfig;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static java.util.Arrays.asList;

/**
 * Created by Michal on 2017-01-08.
 */
public class Application {


    private final static Properties brokerConfig = new Properties();

    {
        brokerConfig.setProperty("port", "8000");
        brokerConfig.setProperty("host", "localhost");
        brokerConfig.setProperty("allow_anonymous", "true");
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        IResourceLoader classpathLoader = new ClasspathResourceLoader();
        final IConfig classPathConfig = new ResourceLoaderConfig(classpathLoader);

        final Server server = new Server();
        List<? extends InterceptHandler> userHandlers = asList(new AbstractInterceptHandler() {
            @Override
            public void onPublish(InterceptPublishMessage msg) {
                System.out.println("Driver: " + msg.getClientID() +", Topic: " + msg.getTopicName() + ", message: " + new String(msg.getPayload().array()));

            }
        });
        server.startServer(classPathConfig, userHandlers);
        System.out.println("Port: " + classPathConfig.getProperty("port"));


        System.out.println("moquette mqtt broker started, press ctrl-c to shutdown..");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.stopServer()));
        Scanner scan = new Scanner(System.in);
        while(true) {
            int i = scan.nextInt();
            PublishMessage message= new PublishMessage();
            message.setClientId("asdf");
            message.setTopicName("light");
            message.setPayload(ByteBuffer.wrap(new Integer(i).toString().getBytes()));
            message.setQos(AbstractMessage.QOSType.EXACTLY_ONCE);
            server.internalPublish(message);
        }

    }

}
