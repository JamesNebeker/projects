package tetrisGame;


import java.util.Random;
import java.awt.Color;
import java.lang.Math;


public class Shape 
	{
	Color sColor;
	int[][] coords = new int[4][2];
	int sMarker;
	int bad = -1;
	int rotation = 0;
	
	public Shape(int x)
	{
		
		createShape(x);
		
	}
	
	public int setRandom()
	{
		int max = 2;
		int x = (int)(Math.random() * ((max) + 1));
		return x;
				
	}
	public int[][] createShape(int x)
	{
		if (x == 0)
		{
			coords[0][0] = -1;
			coords[0][1] = 0;
			coords[1][0] = 0;
			coords[1][1] = 0;
			coords[2][0] = 0;
			coords[2][1] = 1;
			coords[3][0] = 1;
			coords[3][1] = 0;
			sColor = Color.RED;
			sMarker = 0;
					
		}
		if (x == 1)
		{
			coords[0][0] = -1;
			coords[0][1] = 0;
			coords[1][0] = 0;
			coords[1][1] = 0;
			coords[2][0] = 0;
			coords[2][1] = 1;
			coords[3][0] = 1;
			coords[3][1] = 1;
			sColor = Color.BLUE;
			sMarker = 1;
					
		}
		if (x == 2)
		{
			coords[0][0] = -1;
			coords[0][1] = 0;
			coords[1][0] = 0;
			coords[1][1] = 0;
			coords[2][0] = 1;
			coords[2][1] = 0;
			coords[3][0] = 1;
			coords[3][1] = 1;
			sColor = Color.ORANGE;
			sMarker = 3;
					
		}
		
		return coords;
	}

	public int getX(int square)
	{
	
			return coords[square][0];
		
		
		
			
	}
	public int getY(int square)
	{
		
			return coords[square][1];
		
		
		
			
	}
	public void setX(int square, int val)
	{
		
			coords[square][0] = val;
		
	}
	public void setY(int square, int val)
	{
	
			coords[square][1] = val;
		
		
		
			
	}
	public Color getColor()
	{
		return sColor;
	}
	public int getShape()
	{
		return sMarker;
	}
	
	public int minX()
    {
      int m = coords[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][0]);
      }
      return m;
    }


    public int minY() 
    {
      int m = coords[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][1]);
      }
      return m;
    }
    
    public Shape rotateLeft(Shape oldshape)
    {
    	
    		
    		
    		if (rotation > 3) 
    			rotation = 0;
    		if (oldshape.getShape() == 0)
    		{
    			
    			if (rotation == 0)
    			{
    			 oldshape.setX(0, 0);
    			 oldshape.setY(0, 1);
    			 oldshape.setX(1, 0);
    			 oldshape.setY(1, 0);
    			 oldshape.setX(2, 0);
    			 oldshape.setY(2, bad);
    			 oldshape.setX(3, bad);
    			 oldshape.setY(3, 0);
    			 
    			 
    			 
    			} else if (rotation == 1)
    			{
    				oldshape.setX(0, -1);
    				oldshape.setY(0, 0);
    				oldshape.setX(1, 0);
    				oldshape.setY(1, 0);
    				oldshape.setX(2, 1);
    				oldshape.setY(2, 0);
    				oldshape.setX(3, 0);
    				oldshape.setY(3, bad);
    			
    				
    				
    			} else if (rotation == 2)
    			{
    				 oldshape.setX(0, 0);
        			 oldshape.setY(0, 1);
        			 oldshape.setX(1, 0);
        			 oldshape.setY(1, 0);
        			 oldshape.setX(2, 0);
        			 oldshape.setY(2, bad);
        			 oldshape.setX(3, 1);
        			 oldshape.setY(3, 0);
        			 
    			} else if (rotation == 3)
        		{
    				oldshape.setX(0, bad);
        			oldshape.setY(0, 0);
        			oldshape.setX(1, 0);
        			oldshape.setY(1, 0);
        			oldshape.setX(2, 1);
        			oldshape.setY(2, 0);
        			oldshape.setX(3, 0);
        			oldshape.setY(3, 1);
        		}
    		} else if (oldshape.getShape() == 1)
    		{
    			if (rotation == 0)
    			{
    			 oldshape.setX(0, bad);
    			 oldshape.setY(0, 1);
    			 oldshape.setX(1, bad);
    			 oldshape.setY(1, 0);
    			 oldshape.setX(2, 0);
    			 oldshape.setY(2, 0);
    			 oldshape.setX(3, 0);
    			 oldshape.setY(3, bad);
    			 
    			 
    			 
    			} else if (rotation == 1)
    			{
    			 oldshape.setX(0, bad);
       			 oldshape.setY(0, 0);
       			 oldshape.setX(1, 0);
       			 oldshape.setY(1, 0);
       			 oldshape.setX(2, 0);
       			 oldshape.setY(2, 1);
       			 oldshape.setX(3, 1);
       			 oldshape.setY(3, 1);
    			 
    				
    				
    			} else if (rotation == 2)
    			{
    				 oldshape.setX(0, bad);
        			 oldshape.setY(0, 1);
        			 oldshape.setX(1, bad);
        			 oldshape.setY(1, 0);
        			 oldshape.setX(2, 0);
        			 oldshape.setY(2, 0);
        			 oldshape.setX(3, 0);
        			 oldshape.setY(3, bad);
    			}else if (rotation == 3)
    			{
       			 	oldshape.setX(0, bad);
          			 oldshape.setY(0, 0);
          			 oldshape.setX(1, 0);
          			 oldshape.setY(1, 0);
          			 oldshape.setX(2, 0);
          			 oldshape.setY(2, 1);
          			 oldshape.setX(3, 1);
          			 oldshape.setY(3, 1);
       			 
       				
       				
       			}
    			
        		
        			
    		} else if (oldshape.getShape() == 3)
    		{
    			if (rotation == 0)
    			{
    			 oldshape.setX(0, bad);
    			 oldshape.setY(0, 1);
    			 oldshape.setX(1, 0);
    			 oldshape.setY(1, 1);
    			 oldshape.setX(2, 0);
    			 oldshape.setY(2, 0);
    			 oldshape.setX(3, 0);
    			 oldshape.setY(3, bad);
    			 
    			 
    			 
    			} else if (rotation == 1)
    			{
    			 oldshape.setX(0, 1);
       			 oldshape.setY(0, 0);
       			 oldshape.setX(1, 0);
       			 oldshape.setY(1, 0);
       			 oldshape.setX(2, bad);
       			 oldshape.setY(2, 0);
       			 oldshape.setX(3, bad);
       			 oldshape.setY(3, bad);
    			 
    				
    				
    			} else if (rotation == 2)
    			{
    				 oldshape.setX(0, 1);
        			 oldshape.setY(0, bad);
        			 oldshape.setX(1, 0);
        			 oldshape.setY(1, bad);
        			 oldshape.setX(2, 0);
        			 oldshape.setY(2, 0);
        			 oldshape.setX(3, 0);
        			 oldshape.setY(3, 1);
        			 
    			}	else if (rotation == 3)
    			{
       			 	
    				oldshape.setX(0, bad);
       			 oldshape.setY(0, 1);
       			 oldshape.setX(1, 0);
       			 oldshape.setY(1, 1);
       			 oldshape.setX(2, 0);
       			 oldshape.setY(2, 0);
       			 oldshape.setX(3, 0);
       			 oldshape.setY(3, bad);
       				
       				
       			}
    			
    		}
    			
    			
    			
    		
    		
    	

    		rotation++;
    	return oldshape;
    }
	}