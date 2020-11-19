package proyecto2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ventana extends JPanel implements ActionListener , KeyListener, MouseListener, MouseWheelListener {
	// ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    public JMenuBar arc;
    public JMenu uno;
    public JMenuItem u,u1,u2,u3,u4,u5,u6,u7,u8;
    public JButton b,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int lo;
    
    private punto [] figura;
	private punto[] p;
    public ventana (String titulo, punto[] figura) {
    	// inicializar la ventana
        ventana = new JFrame("Arte contextual hermano");
        // definir tamaño a ventana
        ventana.setSize(1200, 1200);
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        arc = new JMenuBar();
        u4 = new JMenuItem("Reflexion en x");
        u5 = new JMenuItem("Reflexion en y");
        u6 = new JMenuItem("Reflexion en xy");
        u7 = new JMenuItem("Deformacion");
        u8 = new JMenuItem("Repintar");
        u = new JMenuItem("Escalar");
        u1 = new JMenuItem("Trasladar");
        u2 = new JMenuItem("Rotacion");
        u3 = new JMenuItem("Rotacion negativa");
        uno = new JMenu("Acciones");
    
     //anadir los botones
        add(arc);
        arc.add(uno);
        uno.add(u);
        uno.add(u1);
        uno.add(u2);
        uno.add(u3);
        uno.add(u4);
        uno.add(u5);
        uno.add(u6);
        uno.add(u7);
        uno.add(u8);
        u.addActionListener(this);
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        u4.addActionListener(this);
        u5.addActionListener(this);
        u6.addActionListener(this);
        u7.addActionListener(this);
        u8.addActionListener(this);
        b= new JButton("Escalar");
        b1= new JButton("Trasladar");
        b2=new JButton("RotarIZQ");
        b3= new JButton("RotarDER");
        b4= new JButton("ReflexionX");
        b5= new JButton("ReflexionY");
        b6= new JButton("ReflexionXY");
        b7=new JButton("Deformar");
        b8= new JButton("Re-Hacer");
         b9= new JButton("AYUDA JAJAJA");
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        arc.add(b);
        arc.add(b1);
        arc.add(b2);
        arc.add(b3);
        arc.add(b4);
        arc.add(b5);
        arc.add(b6);
        arc.add(b7);
        arc.add(b8);
        arc.add(b9);
       
      
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          ventana.setFocusable(true);
        ventana.addKeyListener(this);
        ventana.setLocationRelativeTo(null);     
        ventana.setResizable(false);
     
        contenedor = ventana.getContentPane();
        contenedor.setSize(1200, 1080);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura = figura;
        p=figura;
        addMouseListener(this);
        addMouseWheelListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	
    	super.paintComponent(g);
    	g.setColor(Color.blue);
    	this.dibujar(g);  	
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==u){
            Double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de traslado en X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de traslado en Y"));
            this.escalar(x,y);
            repaint();
        }
        if(e.getSource()==u1){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingressr el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingresar el valor de traslado en Y"));
            this.traslacion(x,y);
            ventana.repaint();
        }
        
        if(e.getSource()==u2){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
            this.Rotacion(angulo);
            repaint();
        }
        if(e.getSource()==u3){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
            this.rotacionneg(angulo);
            repaint();
        }
        if(e.getSource()==u4){
            this.reflexionx();
            repaint();
        }
        if(e.getSource()==u5){
            this.reflexiony();
            repaint();
        }
        if(e.getSource()==u6){
            this.reflexionxy();
            repaint();
        }
        if(e.getSource()==u7){
            double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de deformacion en X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de deformacion en Y"));
            this.deformacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==u8){
            this.redibujar();
            repaint();
        }
        if(e.getSource()==b){
            this.escalar(.8,.8);
            ventana.repaint();
        }
        if(e.getSource()==b1){
            this.traslacion(15,15);
            ventana.repaint();
        }
        if(e.getSource()==b2){
            this.Rotacion(10);
            repaint();
        }
        if(e.getSource()==b3){
            this.rotacionneg(10);
            repaint();
        }
        if(e.getSource()==b4){
            this.reflexionx();
            repaint();
        }
        if(e.getSource()==b5){
            this.reflexiony();
            repaint();
        }
        if(e.getSource()==b6){
            this.reflexionxy();
            repaint();
        }
        if(e.getSource()==b7){
            this.deformacion(.5,.5);
            ventana.repaint();
        }
        if(e.getSource()==b8){
            this.redibujar();
            repaint();
        }
         if(e.getSource()==b9){
         JOptionPane.showMessageDialog(null, "Debes pulsar en acciones para ver la barra de menu bro \n Recuerda solo coloca numeros nada de letras :) \n Las teclas para hacer acciones son: \n A \n B \n C"+
                 "\n D \nE \n F \n G \n H \n I");
         }
    }
  
    public void traslacion(int xf, int yf){
        for (punto punto : figura) {
        //punto x
        //punto y
            punto.setX((int)(punto.getX() + xf));
            punto.setY((int)(punto.getY() + yf));
        }
    }
      public void escalar(double fx, double fy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (punto punto : figura) {
        //punto x
        //punto y
            punto.setX((int)(((punto.getX() - tx)* fx) + tx));
            punto.setY((int)(((punto.getY() - ty)* fy) + ty));
          
        }
    }
        public void rotacionneg(double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (punto punto : figura) {
        //punto x:((a-tx)cos + (b-ty)(sen)) +tx
        //punto y: (-(a-tx)(sen) + (b-ty)(cos))+ty
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))+(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)(-(punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
    public void Rotacion (double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (punto punto : figura) {
        //punto x
        //punto y
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))-(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)((punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
  
    public void reflexionx(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(punto punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) (punto.getY()-ty)+ty);
        }
    }public void reflexiony(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(punto punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) (punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void reflexionxy(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(punto punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void deformacion(double dx, double dy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (punto punto : figura) {
        //punto x:((x - tx) + (b - ty) * dx) + tx
        //punto y: ((y - ty) * dy + (b – ty )) + ty
            punto.setX((int)(((punto.getX() - tx)+ (punto.getY()-ty)*dx + tx)));
            punto.setY((int)(((punto.getY() - ty)* dy + (punto.getY()-ty) + ty)));
        }
    }
    public void setFigura(punto figura[]){
        this.figura=figura;
    }
    public void redibujar(){
        punto fig[] = {
        	
	       
                    new punto(400, 200),
                    new punto(300, 200),
	            new punto(300, 250),
	            new punto(400, 250),
                    new punto(400, 300),
                    new punto(300, 300),
	            new punto(300, 350),
	            new punto(400, 350),
                    new punto(400, 400),
                    new punto(300, 400),
	            new punto(300, 450),
	            new punto(400, 450),
                    new punto(400, 500),
                    new punto(300, 500),
	            new punto(300, 550),
	            new punto(400, 550),
                    new punto(400, 600),
                    new punto(300, 600),
	            new punto(300, 650),
	            new punto(400, 650),
                    new punto(650, 650),
                    new punto(650, 400),
	            new punto(450, 250),
	            new punto(450, 300),
	            new punto(400, 300),
	            new punto(400, 250),
                    new punto(400, 250),
	            new punto(400, 200),
	            new punto(300, 200),
	            new punto(300, 250),
	            new punto(400, 250),
                    new punto(650, 250),
	            new punto(700, 250),
	            new punto(700, 300),
	            new punto(650, 300),
	            new punto(650, 250),
                    new punto(700, 300), 
	            new punto(750, 300),
	            new punto(750, 450),
	            new punto(700, 450),
	            new punto(700, 300),
                    new punto(700, 450),
	            new punto(700, 500),
	            new punto(650, 500),
	            new punto(650, 450),
	            new punto(700, 450),
	            new punto(650, 500),
	            new punto(650, 550),
	            new punto(600, 550),
	            new punto(600, 500),
	            new punto(650, 500),
                    
                    
           
        };
        setFigura(fig);
        repaint();
    }
    
    //dibujar la figura original 
	

	    

	    @Override
	    public void keyReleased(KeyEvent e) {
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
	        
	        
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
	        if(e.getButton()==1){
	            this.traslacion(20,20);
	            ventana.repaint();
	        }
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
	      if(e.getButton()==3){
	            this.traslacion(-20,-20);
	            repaint();
	        }
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	    }

	    @Override
	    public void mouseWheelMoved(MouseWheelEvent e) {
	        double scroll = .1;
	        scroll = (e.getWheelRotation() > 0) ? 1 + scroll : 1 - scroll;
	        this.escalar( scroll, scroll);
	        repaint();
	    }
            private void dibujar(Graphics g) {
		for(int i=0; i<figura.length -1;i++) {
			g.drawLine(this.figura[i].getX(),
					this.figura[i].getY(),
					this.figura[i +1].getX(),
					this.figura[i +1].getY());
		}
	}
	
	 @Override
	    public void keyTyped(KeyEvent e) {
	    }
	 
	 @Override
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_A){
	            this.escalar(.9,.9 );
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_B){
	            this.traslacion(10, 1);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_C){
	            this.Rotacion(5.0);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_D){
	            this.rotacionneg(5.0);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_E){
	            this.reflexionx();
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_F){
	            this.reflexiony();
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_G){
	            this.reflexionxy();
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_H){
	            this.deformacion(.1, .1);
	            repaint();
	        }
	        if(e.getKeyCode()==KeyEvent.VK_I){
	            this.redibujar();
	            repaint();
	        }
	
	

}
}