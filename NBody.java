public class NBody{
	public static double readRadius(String location){
		In in = new In(location);
		int number_solar = in.readInt();
		double universe_radius = in.readDouble();
		/*System.out.println("radius" + universe_radius);
		System.out.println("next " + in.readAllStrings());*/
		return universe_radius;
	}
	public static Planet[] readPlanets(String location){
		double p_xxPos;
		double p_yyPos;
		double p_xxVel;
		double p_yyVel;
		double p_mass;
		String p_imgFileName;
		Planet[] Planetlist = new Planet[5];
		In in = new In(location);
		int number_solar =  in.readInt();
		double universe_radius = in.readDouble();
		for(int i = 0;i<number_solar;i++){
			p_xxPos = in.readDouble();
			p_yyPos = in.readDouble();
			p_xxVel = in.readDouble();
			p_yyVel = in.readDouble();
			p_mass = in.readDouble();
			p_imgFileName = in.readString();
			Planetlist[i] = new Planet(p_xxPos,p_yyPos,p_xxVel,p_yyVel
				,p_mass,p_imgFileName);
		}
		return Planetlist;
	}
	public static void main(String[] args) {

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] Planets_list = NBody.readPlanets(filename);
		double Univers_r = NBody.readRadius(filename);
		StdDraw.setScale(NBody.readRadius(filename)*-1,NBody.readRadius(filename));
		StdDraw.clear();
		StdDraw.picture(0,0,"C:/Users/lenovo/cs61b/proj0/images/starfield.jpg");
		for(int i=0;i<Planets_list.length;i++){
			Planets_list[i].draw();
			/*System.out.println(Planets_list[i].imgFileName);*/
		}
		StdDraw.show();
		StdDraw.enableDoubleBuffering();
		double[] xForces = new double[5];
		double[] yForces = new double[5];
		for(double t1 = 0; t1<=T;t1+=dt){
			for(int j=0;j<Planets_list.length;j++){

				xForces[j] = Planets_list[j].calcNetForceExertedByX(Planets_list);
				yForces[j] = Planets_list[j].calcNetForceExertedByY(Planets_list);
				/*System.out.println(xForces[j]);
				System.out.println(yForces[j]);*/
			}

			for(int i = 0;i<Planets_list.length;i++){
				Planets_list[i].update(t1,xForces[i],yForces[i]);
			}
		StdDraw.picture(0,0,"C:/Users/lenovo/cs61b/proj0/images/starfield.jpg");
		for(int k=0;k<Planets_list.length;k++){
			Planets_list[k].draw();
			/*System.out.println(Planets_list[i].imgFileName);*/
		}
		StdDraw.show();
		StdDraw.pause(10);
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}

}