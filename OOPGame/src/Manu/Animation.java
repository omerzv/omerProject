package Manu;

import java.util.concurrent.TimeUnit;

import objects.Handler;

public class Animation {
	private static boolean RUN=true;

	public static void setRun() {
		RUN=false;
	}

	/**
	 * @param handler 
	 * 
	 * making the animations to the start manu
	 *first adding to the handler the left animation 
	 *after 600 milliseconds the right one
	 *
	 *repeat every 2.5 seconds
	 */
	public static void startAnima(Handler handler)  {
		while(RUN) {
			handler.addObject(new LineAnimation(handler, 0, StartManu.HEIGHT-50, 6, -6));
			handler.addObject(new LineAnimation(handler, 0, StartManu.HEIGHT-50, 5, -7));
			handler.addObject(new LineAnimation(handler, 0, StartManu.HEIGHT-50, 4, -8));
			handler.addObject(new LineAnimation(handler, 0, StartManu.HEIGHT-50, 7, -5));
			handler.addObject(new LineAnimation(handler, 0, StartManu.HEIGHT-50, 8, -4));
			handler.addObject(new CurveEnemy(handler, 0, StartManu.HEIGHT-50, 2, -9,true));
			handler.addObject(new CurveEnemy(handler, 0, StartManu.HEIGHT-50, 9,-3,false));
			try {
				TimeUnit.MILLISECONDS.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			handler.addObject(new LineAnimation(handler, StartManu.WIDTH, StartManu.HEIGHT-50, -6, -6));
			handler.addObject(new LineAnimation(handler, StartManu.WIDTH, StartManu.HEIGHT-50, -5, -7));
			handler.addObject(new LineAnimation(handler, StartManu.WIDTH, StartManu.HEIGHT-50, -4, -8));
			handler.addObject(new LineAnimation(handler, StartManu.WIDTH, StartManu.HEIGHT-50, -7, -5));
			handler.addObject(new LineAnimation(handler, StartManu.WIDTH, StartManu.HEIGHT-50, -8, -4));
			handler.addObject(new CurveEnemy(handler, StartManu.WIDTH, StartManu.HEIGHT-50, -2, -9,true));
			handler.addObject(new CurveEnemy(handler, StartManu.WIDTH, StartManu.HEIGHT-50, -9,-3,false));
			try {
				TimeUnit.MILLISECONDS.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				handler.getList();
				
			}
			
		}
	}
}
