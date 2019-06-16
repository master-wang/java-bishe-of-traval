package com.acat.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.acat.dto.Message;
import com.google.gson.Gson;

@ServerEndpoint("/chatSocket")
public class ChatSocket {

    private  static  Set<ChatSocket>  sockets=new HashSet<ChatSocket>();

    private  static  List<String>   names=new ArrayList<String>();
    private  Session  session;
    private String username;
    private Gson gson=new Gson();

    @OnOpen
    public  void open(Session  session){
        this.session=session;
        sockets.add(this);

        String  queryString = session.getQueryString();
        System.out.println(queryString);
        this.username = queryString.substring(queryString.indexOf("=")+1);
        names.add(this.username);


        Message message=new Message();
        message.setAlert(this.username+"进入聊天室！！");
        message.setNames(names);

        broadcast(sockets, gson.toJson(message) );

    }
    @OnMessage
    public  void receive(Session  session,String msg ){

        Message  message=new Message();
        message.setSendMsg(msg);
        message.setFrom(this.username);
        message.setDate(new Date().toLocaleString());

        broadcast(sockets, gson.toJson(message));
    }

    @OnClose
    public  void close(Session session){
        sockets.remove(this);
        names.remove(this.username);

        Message   message=new Message();
        message.setAlert(this.username+"退出聊天室！！");
        message.setNames(names);

        broadcast(sockets, gson.toJson(message));
    }

    public void broadcast(Set<ChatSocket>  ss ,String msg ){

        for (Iterator iterator = ss.iterator(); iterator.hasNext();) {
            ChatSocket chatSocket = (ChatSocket) iterator.next();
            try {
                chatSocket.session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
