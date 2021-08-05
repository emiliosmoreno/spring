package com.emiliosmoreno.springboot.command.core.msdos;

import java.io.IOException;

import com.emiliosmoreno.springboot.command.core.Command;
import com.emiliosmoreno.springboot.command.core.InputStreamConsumer;

public class Command_Dir extends Command{

	public Command_Dir() {
		
	}
	@Override
	public Process executePrivate() {
		Process p=null;
		
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
            pb.redirectError();
            p = pb.start();
            InputStreamConsumer isc = new InputStreamConsumer(p.getInputStream());
            isc.start();
//			exitCode = p.waitFor();
//            System.out.println("Process terminated with " + exitCode);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return p;
	}

}
