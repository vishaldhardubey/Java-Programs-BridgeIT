package com.bridgelabz.structuraldesignpattern;

public class PrototypeCommandProxy implements PrototypeCommandExecutor {

		private boolean isAdmin;
		private PrototypeCommandExecutor executor;
		
		public PrototypeCommandProxy(String user, String pwd){
			if("Vishal".equals(user) && "vishal1994".equals(pwd)) {
				isAdmin=true;
			executor = new PrototypeCommandExeImplementation();
			}
		}
		
		@Override
		public void runCommand(String cmd) throws Exception {
			if(isAdmin){
				executor.runCommand(cmd);
			}else{
				if(cmd.trim().startsWith("rm")){
					throw new Exception("rm command is not allowed for non-admin users.");
				}else{
					executor.runCommand(cmd);
				}
			}
		}
}
