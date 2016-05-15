package org.lx.patterns.syn.q3;

public class Test implements Runnable{

    private int x = 0;

    public void run(){
    	x++;
    }
    public int getX() {
		return x;
	}

    public static void main(String args[]) throws InterruptedException{
        Thread thread = null;
        while(true){
        	Test test = new Test();
	        for (int i = 0; i < 10000; i++) {
				thread = new Thread(test);
				thread.start();
				thread.join();
			}
	        if(test.getX() != 10000){
	        	System.out.println(":::::::::"+test.getX());
	        }
	        	break;
        }
    }
}
