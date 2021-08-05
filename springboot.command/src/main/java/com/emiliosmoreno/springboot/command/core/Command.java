package com.emiliosmoreno.springboot.command.core;

import java.io.IOException;

public abstract class Command {

    public abstract Process executePrivate() throws IOException;
    
    public int execute(){
    	int exitCode=-1;
		
		try {
			Process p = executePrivate();
			exitCode = p.waitFor();
            System.out.println("Process terminated with " + exitCode);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return exitCode;
    	
    }
}
