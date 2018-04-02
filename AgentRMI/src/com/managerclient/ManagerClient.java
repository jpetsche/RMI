package com.managerclient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ManagerClient
{
    private ManagerClient() {}

    public static void main(String[] args)
    {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            RMIInterface stub = (RMIInterface) registry.lookup("Hello");
            String response = stub.GetLocalOS();
            System.out.println("Local OS: " + response);
        } catch (Exeption e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}