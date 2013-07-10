package mains;


import java.io.*;


public class paquet  implements Serializable {
    private String src;
    private String dest;
    private String data;

    public void SetData (String Data)
    {
         data = Data;
    }

    public String GetData ()
    {
        return data;
    }

    public void SetSrc (String Src)
    {
         src = Src;
    }

    public String GetSrc ()
    {
        return src;
    }

    public void SetDest (String Dest)
    {
         dest = Dest;
    }

    public String GetDest ()
    {
        return dest;
    }

}