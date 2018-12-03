package bom.control;

import java.awt.Graphics2D;

import bom.Image.Img;
import bom.map.Setmap;
import bom.map.Value;
import bom.model.Bomb;
import bom.model.Bomber;
import bom.model.MrBomb;
import bom.model.MrCreeps;
import bom.model.MrFlame;
import bom.model.Wall;

public class Action {
	private Setmap map = new Setmap(2);
	private Bomber bomber = new Bomber(0, 0, 50, 5);
	private MrBomb bombMr = new MrBomb();
	private MrFlame flameMr = new MrFlame();
	private MrCreeps creepMr = new MrCreeps();


	public void addBomb(long time) {
		int x = bomber.getX()+ 50;
		int y = bomber.getY() + 85;
		if(bomber.getCountBomb() != 0) {
			switch(bomber.getStart()+1) {
			case Value.UP: {
				double min = 10000;
				int index = 0, i = 0;
				
				for(Wall wall : map.getListWall_0()) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if((y <= y1 && Math.abs(x-x1) < 30 && y-y1 < 15)|| (y1-y < 30 && Math.abs(x-x1) < 30)) {
						if(Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1)) < min) {
							min = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
							index = i;
						}
					}
					i++;
				}
								
				
				boolean check = false;
				if(!bombMr.getArrBomb().isEmpty()) {
					for(Bomb bomb : bombMr.getArrBomb())
						if(map.getListWall_0().get(index).getX()*Value.SIZE == bomb.getX() && map.getListWall_0().get(index).getY()*Value.SIZE == bomb.getY()) {
							check = true;
							break;
						}
				}
				if(!check) {
					bombMr.addBomb(map.getListWall_0().get(index).getX()*Value.SIZE,map.getListWall_0().get(index).getY()*Value.SIZE, time, bomber.getLengBomb());
					for(int j = 0; j < map.getListWall().size(); j++) {
						if(map.getListWall_0().get(index).getX() == map.getListWall().get(j).getX() && map.getListWall_0().get(index).getY() == map.getListWall().get(j).getY()) {
							map.getListWall().get(j).setType(-4);
							break;
							}
					}				
					bomber.setCountBomb(bomber.getCountBomb()-1);
				
				}
				return;
			}
			case Value.DOWN: {
				double min = 10000;
				int index = 0, i = 0;
				
				for(Wall wall : map.getListWall_0()) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if((y >= y1 && Math.abs(x-x1) < 30 && y-y1 < 35)|| (y1-y < 15 && Math.abs(x-x1) < 30)) {
						if(Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1)) <= min) {
							min = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
							index = i;
						}
					}
					i++;
				}
				
				
				boolean check = false;
				if(!bombMr.getArrBomb().isEmpty()) {
					for(Bomb bomb : bombMr.getArrBomb())
						if(map.getListWall_0().get(index).getX()*Value.SIZE == bomb.getX() && map.getListWall_0().get(index).getY()*Value.SIZE == bomb.getY()) {
							check = true;
							break;
						}
				}
				if(!check) {
					bombMr.addBomb(map.getListWall_0().get(index).getX()*Value.SIZE,map.getListWall_0().get(index).getY()*Value.SIZE, time, bomber.getLengBomb());
					for(int j = 0; j < map.getListWall().size(); j++) {
						if(map.getListWall_0().get(index).getX() == map.getListWall().get(j).getX() && map.getListWall_0().get(index).getY() == map.getListWall().get(j).getY()) {
							map.getListWall().get(j).setType(-4);
							break;
							}
					}		
					bomber.setCountBomb(bomber.getCountBomb()-1);	
				}
				return;
			}
			case Value.RIGHT: {
				double min = 10000;
				int index = 0, i = 0;

				for(Wall wall : map.getListWall_0()) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if((x > x1 || x1-x <= 5 )&& x-x1 <= 75 && Math.abs(y-y1) <= 110) {
						if(Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1)) <= min) {
							min = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
							index = i;
						}
					}
					i++;
				}
					
				
				boolean check = false;
					if(!bombMr.getArrBomb().isEmpty()) {
						for(Bomb bomb : bombMr.getArrBomb())
							if(map.getListWall_0().get(index).getX()*Value.SIZE == bomb.getX() && map.getListWall_0().get(index).getY()*Value.SIZE == bomb.getY()) {
								check = true;
								break;
							}
					}
					if(!check) {
						bombMr.addBomb(map.getListWall_0().get(index).getX()*Value.SIZE,map.getListWall_0().get(index).getY()*Value.SIZE, time, bomber.getLengBomb());
						for(int j = 0; j < map.getListWall().size(); j++) {
							if(map.getListWall_0().get(index).getX() == map.getListWall().get(j).getX() && map.getListWall_0().get(index).getY() == map.getListWall().get(j).getY()) {
								map.getListWall().get(j).setType(-4);
								break;
								}
						}		
						bomber.setCountBomb(bomber.getCountBomb()-1);				
					}
					return;
			}
			case Value.LEFT: {
				double min = 10000;
				int index = 0, i = 0;
				
				y = y-10;
				for(Wall wall : map.getListWall_0()) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if(Math.abs(y-y1) < 25 && ((x < x1 && x1-x <= 25) || (x > x1 && x-x1 <= 15))) {
						if(Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1)) <= min) {
							min = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
							index = i;
						}
					}
					i++;
				}
				
				boolean check = false;
				if(!bombMr.getArrBomb().isEmpty()) {
					for(Bomb bomb : bombMr.getArrBomb())
						if(map.getListWall_0().get(index).getX()*Value.SIZE == bomb.getX() && map.getListWall_0().get(index).getY()*Value.SIZE == bomb.getY()) {
							check = true;
							break;
						}
				}
				if(!check) {
					bombMr.addBomb(map.getListWall_0().get(index).getX()*Value.SIZE,map.getListWall_0().get(index).getY()*Value.SIZE, time, bomber.getLengBomb());
					for(int j = 0; j < map.getListWall().size(); j++) {
						if(map.getListWall_0().get(index).getX() == map.getListWall().get(j).getX() && map.getListWall_0().get(index).getY() == map.getListWall().get(j).getY()) {
							map.getListWall().get(j).setType(-4);
							break;
							}
					}		
					bomber.setCountBomb(bomber.getCountBomb()-1);				
				}
				return;
			}
			}
		}	
	}
	
	public void timeBomb(long time) {
		 if(time%80==0){
			 bombMr.update();
		 }
	}
	
	public void bustBoob(long time) {
		
		
		for(int i = 0 ; i < flameMr.getArrFlame().size(); i++){
			if(time - flameMr.getArrFlame().get(i).getTime() >= 200){
				flameMr.getArrFlame().remove(i);
			}
		}
		
		for(int i=0; i< bombMr.getArrBomb().size();i++){
			if(time - bombMr.getArrBomb().get(i).getTime()>=2000){
				bomber.setCountBomb(bomber.getCountBomb()+1);
				check(i, time);
			}
		}		
	}
	
	public void check(int a, long time) {
		flameMr.addFlame(bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), time, Img.arrFlameImg.get(0), 0);
		
		for(int i = 1; i <= bomber.getLengBomb(); i++) {
			boolean check = false;
			for(int j = 0; j < map.getListWall().size(); j++) {
				if(map.getListWall().get(j).getX() == bombMr.getArrBomb().get(a).getX()/50+i && map.getListWall().get(j).getY() == bombMr.getArrBomb().get(a).getY()/50) {
					if(map.getListWall().get(j).getType() == 2 ||map.getListWall().get(j).getType() == 1) {
						if(map.getListWall().get(j).getType() == 2) {
							for(int z = 0; z < map.getListWall_2().size(); z++) {
								map.getListWall_0().add(new Wall(map.getListWall().get(j).getX(), map.getListWall().get(j).getY(), map.getListWall_0().get(0).getImg(), 0));
								if(map.getListWall_2().get(z).getXtam() == map.getListWall().get(j).getXtam() &&
								map.getListWall_2().get(z).getYtam() == map.getListWall().get(j).getYtam()) {
									map.getListWall_2().remove(z);
								}
								map.getListWall().get(j).setImg(map.getListWall_0().get(0).getImg());
								map.getListWall().get(j).setType(0);
							}
						}
						check = true;
					}
					
				}
			}
			if(check)
				break;
			if(!check) {
				if(i < bomber.getLengBomb()) {
					flameMr.addFlame((bombMr.getArrBomb().get(a).getX()/50+i)*Value.SIZE, bombMr.getArrBomb().get(a).getY(), bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), time, Img.arrFlameImg.get(1), 1);
				}
				else {
					flameMr.addFlame((bombMr.getArrBomb().get(a).getX()/50+i)*Value.SIZE, bombMr.getArrBomb().get(a).getY(), bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), time, Img.arrFlameImg.get(4), 4);
					
				}
			}
		}
		
		for(int i = 1; i <= bomber.getLengBomb(); i++) {
			boolean check = false;
			for(int j = 0; j < map.getListWall().size(); j++) {
				if(map.getListWall().get(j).getX() == bombMr.getArrBomb().get(a).getX()/50-i && map.getListWall().get(j).getY() == bombMr.getArrBomb().get(a).getY()/50) {
					if(map.getListWall().get(j).getType() == 2 ||map.getListWall().get(j).getType() == 1) {
						if(map.getListWall().get(j).getType() == 2) {
							for(int z = 0; z < map.getListWall_2().size(); z++) {
								map.getListWall_0().add(new Wall(map.getListWall().get(j).getX(), map.getListWall().get(j).getY(), map.getListWall_0().get(0).getImg(), 0));
								if(map.getListWall_2().get(z).getXtam() == map.getListWall().get(j).getXtam() &&
								map.getListWall_2().get(z).getYtam() == map.getListWall().get(j).getYtam()) {
									map.getListWall_2().remove(z);
								}
								map.getListWall().get(j).setImg(map.getListWall_0().get(0).getImg());
								map.getListWall().get(j).setType(0);
							}
						}
						check = true;

					}
					
				}
			}
			if(check)
				break;
			if(!check) {
				if(i < bomber.getLengBomb()) {
					
					flameMr.addFlame((bombMr.getArrBomb().get(a).getX()/50-i)*Value.SIZE, bombMr.getArrBomb().get(a).getY(), bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), time, Img.arrFlameImg.get(1), 1);
				}
				else {
					flameMr.addFlame((bombMr.getArrBomb().get(a).getX()/50-i)*Value.SIZE, bombMr.getArrBomb().get(a).getY(), bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), time, Img.arrFlameImg.get(2), 2);
					
				}
			}
			
		}
		for(int i = 1; i <= bomber.getLengBomb(); i++) {
			boolean check = false;
			for(int j = 0; j < map.getListWall().size(); j++) {
				if(map.getListWall().get(j).getX() == bombMr.getArrBomb().get(a).getX()/50 && map.getListWall().get(j).getY() == bombMr.getArrBomb().get(a).getY()/50 + i) {
					if(map.getListWall().get(j).getType() == 2 ||map.getListWall().get(j).getType() == 1) {
						if(map.getListWall().get(j).getType() == 2) {
							for(int z = 0; z < map.getListWall_2().size(); z++) {
								if(map.getListWall_2().get(z).getXtam() == map.getListWall().get(j).getXtam() &&
								map.getListWall_2().get(z).getYtam() == map.getListWall().get(j).getYtam()) {
									map.getListWall_2().remove(z);
								}
								map.getListWall().get(j).setImg(map.getListWall_0().get(0).getImg());
								map.getListWall().get(j).setType(0);
								map.getListWall_0().add(new Wall(map.getListWall().get(j).getX(), map.getListWall().get(j).getY(), map.getListWall_0().get(0).getImg(), 0));
							}
						}
						check = true;
					}
				}
			}
			if(check)
				break;
			if(!check) {
				if(i < bomber.getLengBomb()) {
					flameMr.addFlame(bombMr.getArrBomb().get(a).getX(), (bombMr.getArrBomb().get(a).getY()/50+i)*Value.SIZE, bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), time, Img.arrFlameImg.get(1), 1);
				}
				else {
					flameMr.addFlame(bombMr.getArrBomb().get(a).getX(), (bombMr.getArrBomb().get(a).getY()/50+i)*Value.SIZE, bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), time, Img.arrFlameImg.get(5), 5);
					
				}
			}
			
		}
		
		for(int i = 1; i <= bomber.getLengBomb(); i++) {
			boolean check = false;
			for(int j = 0; j < map.getListWall().size(); j++) {
				if(map.getListWall().get(j).getX() == bombMr.getArrBomb().get(a).getX()/50 && map.getListWall().get(j).getY() == bombMr.getArrBomb().get(a).getY()/50 - i) {
					if(map.getListWall().get(j).getType() == 2 ||map.getListWall().get(j).getType() == 1) {
						if(map.getListWall().get(j).getType() == 2) {
							for(int z = 0; z < map.getListWall_2().size(); z++) {
								if(map.getListWall_2().get(z).getXtam() == map.getListWall().get(j).getXtam() &&
								map.getListWall_2().get(z).getYtam() == map.getListWall().get(j).getYtam()) {
									map.getListWall_2().remove(z);
								}
								map.getListWall().get(j).setImg(map.getListWall_0().get(0).getImg());
								map.getListWall().get(j).setType(0);
								map.getListWall_0().add(new Wall(map.getListWall().get(j).getX(), map.getListWall().get(j).getY(), map.getListWall_0().get(0).getImg(), 0));
							}
						}
						check = true;
					}
				}
			}
			if(check)
				break;
			if(!check) {
				if(i < bomber.getLengBomb()) {
					flameMr.addFlame(bombMr.getArrBomb().get(a).getX(), (bombMr.getArrBomb().get(a).getY()/50-i)*Value.SIZE, bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), time, Img.arrFlameImg.get(1), 1);
				}
				else {
					flameMr.addFlame(bombMr.getArrBomb().get(a).getX(), (bombMr.getArrBomb().get(a).getY()/50-i)*Value.SIZE, bombMr.getArrBomb().get(a).getX(), bombMr.getArrBomb().get(a).getY(), time, Img.arrFlameImg.get(3), 3);
					
				}
			}
			
		}
		
		for(int j = 0; j < map.getListWall().size(); j++) {
			if(bombMr.getArrBomb().get(a).getX()/50 == map.getListWall().get(j).getX() && bombMr.getArrBomb().get(a).getY()/50 == map.getListWall().get(j).getY()) {
				map.getListWall().get(j).setType(0);
				break;
				}
		}
		bomber.checkDie(flameMr);
		creepMr.checkDie(flameMr);
		bombMr.getArrBomb().remove(a);

	}

	public Bomber getBomber() {
		return bomber;
	}
	
	public int getMove(int orient) {
		int x = bomber.getX()+ 50;
		int y = bomber.getY() + 85;
		if(orient == Value.UP) {
			for(Wall wall : map.getListWall()) {
				if(wall.getType() == 2 || wall.getType() == 1) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if(y > y1 && Math.abs(x-x1) < 36) {
						if(y-y1 <= 45)
							return 0;
					}	
				}
				if(wall.getType() == -4) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
//					if(Math.abs(y-y1) < 25) {
//						return 1;
//					}
					if(Math.abs(y1-y) == 40  && y > y1 && Math.abs(x-x1) < 35)
						return 0;
					
				}
			
			}
//			for(Wall wall : map.getListWall_1()) {
//				int x1 = wall.getX()*Value.SIZE + 25;
//				int y1 = wall.getY()*Value.SIZE + 25;
//				if(y > y1 && Math.abs(x-x1) < 36) {
//					if(y-y1 <= 45)
//						return 0;
//				}
//			}
//			for(Wall wall : map.getListWall_2()) {
//				int x1 = wall.getX()*Value.SIZE + 25;
//				int y1 = wall.getY()*Value.SIZE + 25;
//				if(y > y1 && Math.abs(x-x1) < 36) {
//					if(y-y1 <= 45)
//						return 0;
//				}
//			}
		}
		
		else if(orient == Value.DOWN) {
			for(Wall wall : map.getListWall()) {
				if(wall.getType() == 2 || wall.getType() == 1) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if(y < y1 && Math.abs(x-x1) < 36) {
						if(y1-y <= 30)
							return 0;			
					}
				}
				if(wall.getType() == -4) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
//					if(Math.abs(y-y1) < 25) {
//						return 1;
//					}
					if(Math.abs(y1-y) == 30  && y < y1 && Math.abs(x-x1) < 35)
						return 0;
				}
				
			}
			
			
//			for(Wall wall : map.getListWall_1()) {
//				int x1 = wall.getX()*Value.SIZE + 25;
//				int y1 = wall.getY()*Value.SIZE + 25;
//				if(y < y1 && Math.abs(x-x1) < 36) {
//					if(y1-y <= 30)
//						return 0;			
//				}
//			}
//			for(Wall wall : map.getListWall_2()) {
//				int x1 = wall.getX()*Value.SIZE + 25;
//				int y1 = wall.getY()*Value.SIZE + 25;
//				if(y < y1 && Math.abs(x-x1) < 36) {
//					if(y1-y <= 30)
//						return 0;
//				}
//			}
		}
		
		if(orient == Value.LEFT) {
			for(Wall wall : map.getListWall()) {
				if(wall.getType() == 2) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if(x > x1 && y1-y < 25 && y <= y1)  {
						if(x-x1 <= 50)
							return 0;
					}
					if(x > x1 && y-y1 < 30 && y >= y1)  {
						if(x-x1 <= 50)
							return 0;
					}
					if(x > x1 && y == y1)  {
						if(x-x1 <= 50)
							return 0;
					}
				}
				if(wall.getType() == 1) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if(x > x1 && y1-y < 25 && y <= y1)  {
						if(x-x1 <= 50)
							return 0;
					}
					if(x > x1 && y-y1 < 30 && y >= y1)  {
						if(x-x1 <= 50)
							return 0;
					}
				}
				if(wall.getType() == -4) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
//					if(Math.abs(x-x1) < 25) {
//						return 1;
//					}
					if(Math.abs(x-x1) == 35 && x > x1 && Math.abs(y-y1) < 30)
						return 0;
					
				}
				
			}
//			for(Wall wall : map.getListWall_1()) {
//				int x1 = wall.getX()*Value.SIZE + 25;
//				int y1 = wall.getY()*Value.SIZE + 25;
//				if(x > x1 && y1-y < 25 && y <= y1)  {
//					if(x-x1 <= 50)
//						return 0;
//				}
//				if(x > x1 && y-y1 < 30 && y >= y1)  {
//					if(x-x1 <= 50)
//						return 0;
//				}
//				
//			}
//			for(Wall wall : map.getListWall_2()) {
//				int x1 = wall.getX()*Value.SIZE + 25;
//				int y1 = wall.getY()*Value.SIZE + 25;
//				if(x > x1 && y1-y < 25 && y <= y1)  {
//					if(x-x1 <= 50)
//						return 0;
//				}
//				if(x > x1 && y-y1 < 30 && y >= y1)  {
//					if(x-x1 <= 50)
//						return 0;
//				}
//				if(x > x1 && y == y1)  {
//					if(x-x1 <= 50)
//						return 0;
//				}
//			}
		}
		
		if(orient == Value.RIGHT) {
			for(Wall wall : map.getListWall()) {
				if(wall.getType() == 2 || wall.getType() == -4) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if(x < x1 && y1-y < 25 && y <= y1)  {
						if(x1-x <= 50)
							return 0;
					}
					if(x < x1 && y-y1 < 30 && y >= y1)  {
						if(x1-x <= 50)
							return 0;
					}
					if(x < x1 && y == y1)  {
						if(x1-x <= 50)
							return 0;
					}
				}
				if(wall.getType() == 1) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
					if(x < x1 && y1-y < 25 && y <= y1)  {
						if(x1-x <= 50)
							return 0;
					}
					if(x < x1 && y-y1 < 30 && y >= y1)  {
						if(x1-x <= 50)
							return 0;
					}
				}
				if(wall.getType() == -4) {
					int x1 = wall.getX()*Value.SIZE + 25;
					int y1 = wall.getY()*Value.SIZE + 25;
//					if(Math.abs(Math.sqrt((x-x1)*(x-x1) + (y-y1)+(y-y1))) < 50) {
//						return 1;
//					}
					if(Math.abs(x-x1) == 35 && x < x1 && Math.abs(y-y1) < 30)
						return 0;
				}
				
			}
			
//			for(Wall wall : map.getListWall_1()) {
//				int x1 = wall.getX()*Value.SIZE + 25;
//				int y1 = wall.getY()*Value.SIZE + 25;
//				if(x < x1 && y1-y < 25 && y <= y1)  {
//					if(x1-x <= 50)
//						return 0;
//				}
//				if(x < x1 && y-y1 < 30 && y >= y1)  {
//					if(x1-x <= 50)
//						return 0;
//				}
//				
//			}
//			for(Wall wall : map.getListWall_2()) {
//				int x1 = wall.getX()*Value.SIZE + 25;
//				int y1 = wall.getY()*Value.SIZE + 25;
//				if(x < x1 && y1-y < 25 && y <= y1)  {
//					if(x1-x <= 50)
//						return 0;
//				}
//				if(x < x1 && y-y1 < 30 && y >= y1)  {
//					if(x1-x <= 50)
//						return 0;
//				}
//				if(x < x1 && y == y1)  {
//					if(x1-x <= 50)
//						return 0;
//				}
//			}
		}
		return 1;
	}
	
	public void moveCreep(long time) {
		creepMr.checkImpactBomber(bomber);
		creepMr.moveAllCreeps(map, bomber, time);
	}
	
	public void moveBomber(long time) {
		bomber.moveBomber(time, bombMr);
	}
	
	public boolean checkDie() {
		if(bomber.isDie()){
			return true;
		}
		return false;
	}
	public boolean checkWin() {
		if(creepMr.getArrCreeps().size() == 0){
			return true;
		}
		return false;
	}
	
	public void drawBottomUnit(Graphics2D g) {
		for (int i = 0; i < map.getListWall().size(); i++) {
			map.getListWall().get(i).drawUnit(g);
		}
		flameMr.drawAllFlame(g);
		bombMr.drawAllBomb(g);
		creepMr.drawAllCreeps(g);
		bomber.drawBomber(g);
	}
}
