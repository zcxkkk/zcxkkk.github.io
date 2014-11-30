package com.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class testMutilPing extends Thread{
	
	static Map<String,String> pingMap = new HashMap<String,String>();
	
	public static void main(String[] args) throws Exception {
		int numOfIp = 180;
		final List<String> ipList = new ArrayList<String>();
		for (int i=0; i<numOfIp; i++) {
			ipList.add(i + ".google.com");
		}
		//clock start
		long stime = System.currentTimeMillis();
		//new threads
		Thread threads[] = new Thread[numOfIp];  
		for (int i=0; i<threads.length; i++) { 
			final String nowPingIp = ipList.get(i);
            threads[i] = new Thread(new Runnable(){ 
               @Override 
               public void run() { 
            	   ping(nowPingIp); 
               } 
           }); 
           threads[i].start(); 
       } 
		
        for (int i = 0; i < threads.length; i++){
    		threads[i].join();
        }
        //clock end
        long etime = System.currentTimeMillis();
        System.out.println(numOfIp+" threads took "+ (etime-stime) +"ms");  
        System.out.println("size of map: " + pingMap.size());
        
        //Iterator Map
//      workByKeySet(pingMap);
	}
	
	public static void workByKeySet(Map<String, String> map) {
        Set<String> key = map.keySet();
        int i=0;
        for (Iterator it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            System.out.println((i++)+". "+s + " : " + map.get(s));
        }
    }
	
	public static boolean ping(String ip) {
		long stime = System.currentTimeMillis();
		BufferedReader in = null;
		if (!isNotNull(ip))
			return false;
		boolean flag = false;
		try {
			Runtime r = Runtime.getRuntime();
			int timeout = 500;
			int numOfPack = 2;
			String pingCommand = "ping " + ip.trim() + " -n "+ numOfPack +" -w " + timeout;
			Process p = r.exec(pingCommand);
			if (p == null)
				return false;
			in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				if (line.indexOf("ms") != -1) {
					flag = true;
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		long etime = System.currentTimeMillis();
		long completeTime = etime-stime;
		System.out.println( ip + " took : " + completeTime + "ms" );
		//save record to map
		pingMap.put(ip, String.valueOf(completeTime));
		return flag;
	}
	
	public static boolean isNotNull(String ip) {
		return (ip != null) && (!ip.trim().equals(""));
	}
}
