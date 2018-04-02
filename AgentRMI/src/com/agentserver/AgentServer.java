package com.agentserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.rmiinterface.Beacon;
import com.rmiinterface.RMIInterface;


public class AgentServer extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUID = 1L;
    private List<Beacon> beaconList;

    protected AgentServer(List<Beacon> list) throws RemoteException
    {
        super();
        this.beaconList = list;
    }

    @Override
    public Beacon GetLocalOS(Beacon b) throws RemoteException {
        return null;
    }

    @Override
    public Beacon getLocalTime(Beacon b) throws RemoteException {
        return null;
    }

    private static List<Beacon> initializeList()
    {
        List<Beacon> list = new ArrayList<>();
        char[] arr = new char[4];
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        list.add(new Beacon(1,1,arr, 19001));
        list.add(new Beacon(2,2,arr, 19002));
        list.add(new Beacon(3,3,arr, 19003));
        list.add(new Beacon(4,4,arr, 19004));
        list.add(new Beacon(5,5,arr, 19005));
        return list;
    }

    public static void main(String[] args)
    {
        try{
            Naming.rebind("//localhost/MyAgentServer", new AgentServer(initializeList()));
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}
