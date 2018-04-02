package com.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote
{
    Beacon GetLocalOS(Beacon b) throws RemoteException;
    Beacon getLocalTime(Beacon b) throws RemoteException;
}
