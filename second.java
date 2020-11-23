import java.io.*;
import java.awt.*;
import java.applet.*;
import javax.swing.*;

class secant
{
    public double fd(double a,double b,double x)
    {
        return( (2*a*x)+b);
    }
    public double Secant(double a,double b,double c,double X1, double X2)
    {
        double x1=X1;
        double x2=X2;
        double z=0.0d;
        if(fd(a,b,x1)<0 && fd(a,b,x2)>0)
        {

            for(double i=0;i<11;i++)
            {
                z=x2 - fd(a,b,x2)/((fd(a,b,x2)-fd(a,b,x1))/(x2-x1)) ;

                if (fd(a,b,z)>0)
                {
                    x2=z;
                    continue;
                }
                else
                {
                    x1=z;
                    continue;
                }
            }
            return z;
        }
        else
        {
            System.out.println("wrong initial guess");
        }
        return 10;
    } 
}


public class second extends Applet
{
      TextField text1, text2, text3,text4,text5;
      Label lab1,lab2, lab3,lab4,lab5;
      secant sec = new secant();

      public void init()
      {
       
        lab1 = new Label("Enter the first coeffecient: ");
        lab1.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(lab1);
        text1 = new TextField(8);
        add(text1);
        text1.setText("0");
        lab2 = new Label("Enter the second coeffecient: ");
        lab2.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(lab2);
        text2 = new TextField(8);
        add(text2);
        text2.setText("0");
        lab3 = new Label("Enter the third coeffecient: ");
        lab3.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(lab3);
        text3 = new TextField(8);
        add(text3);
        text3.setText("0");
        lab4 = new Label("Enter the first guess point: ");
        lab4.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(lab4);
        text4 = new TextField(8);
        add(text4);
        lab5 = new Label("Enter the second guess point: ");
        lab5.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(lab5);
        text5 = new TextField(8);
        add(text5);   
      }

      public void paint(Graphics g)
      {
        
          int x=0,y=0,z=0,a=0,b=0;
          String s1,s2,s3,s4,s5;
                    try
          {
                 s1 = text1.getText();
                 x = Integer.parseInt(s1);
                 s2 = text2.getText();
                 y = Integer.parseInt(s2);
                 s3 = text3.getText();
                 z = Integer.parseInt(s3);
                 s4 = text4.getText();
                 a = Integer.parseInt(s4);
                 s5 = text5.getText();
                 b = Integer.parseInt(s5);
           }
          catch(Exception e) {}

           double root = sec.Secant(x,y,z,a,b);
           g.setFont(new Font("Verdana", Font.PLAIN, 18));
           g.drawString("The root is : ",400,105);
           g.drawString(Double.toString(root),510,105);
    }

    public boolean action(Event event, Object obj)
    {
          repaint();
          return true;
    }
}