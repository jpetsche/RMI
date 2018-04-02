package com.rmiinterface;

import java.io.Serializable;

public class Beacon implements Serializable
{
    private int ID;
    private int StartUpTime;
    private char[] IP = new char[4];
    private int CmdPort;

    public Beacon(int id, int startup, char[] ipaddr, int port)
    {
        ID = id;
        StartUpTime = startup;
        for(int i = 0; i < 4; i++)
        {
            IP[i] = ipaddr[i];
        }
        CmdPort = port;
    }

    public int getID()
    {
        return ID;
    }

    public int getStartUpTime()
    {
        return StartUpTime;
    }

    public char[] getIP()
    {
        return IP;
    }

    public int getCmdPort()
    {
        return CmdPort;
    }

    public String toString()
    {
        String beaconstr = "ID: " + ID + "; StartUpTime: " + StartUpTime + "; IP: "
                + IP[0] + "." + IP[1] + "." + IP[2] + "." + IP[3] + "; CmdPort: "
                + CmdPort;
        return beaconstr;
    }

}
