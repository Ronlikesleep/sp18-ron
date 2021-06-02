public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		xxVel = xV;
		yyVel = yV;
		yyPos = yP;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet P){
		/*java copy*/
		this.xxVel = P.xxVel;
		this.xxPos = P.xxPos;
		this.yyPos = P.yyPos;
		this.yyVel = P.yyVel;
		this.mass = P.mass;
		this.imgFileName = P.imgFileName;
	}
	public double calcDistance(Planet J){
		double Distance_result = 0.0;
		Distance_result = Math.sqrt((this.xxPos-J.xxPos)*(this.xxPos-J.xxPos)+
		(this.yyPos-J.yyPos)*(this.yyPos-J.yyPos));
		return Distance_result;
	}
	public double calcForceExertedBy(Planet K){
		double Force_result = 0.0;
		Force_result = (this.mass * K.mass *Planet.G)/
		(this.calcDistance(K)*this.calcDistance(K));
		return Force_result;
	}
	public double calcForceExertedByX(Planet M){
		double Force_resultX = 0.0;
		Force_resultX = this.calcForceExertedBy(M)* 
		(M.xxPos-this.xxPos) / this.calcDistance(M);
		return Force_resultX;
	}
	public double calcForceExertedByY(Planet Q){
		double Force_resultY = 0.0;
		Force_resultY = this.calcForceExertedBy(Q)* 
		(Q.yyPos-this.yyPos) / this.calcDistance(Q);
		return Force_resultY;
	}
	public double calcNetForceExertedByX(Planet[] M){
		double NetForceX = 0.0;
		for(int i = 0;i<M.length;i++){
			if(this.equals(M[i])){
				continue;
			}else{
				NetForceX += this.calcForceExertedByX(M[i]);
			}
		}
		return NetForceX;
	}
	public double calcNetForceExertedByY(Planet[] M){
		double NetForceY = 0.0;
		for(int i = 0;i<M.length;i++){
			if(this.equals(M[i])){
				continue;
			}else{
				NetForceY += this.calcForceExertedByY(M[i]);
			}
		}
		return NetForceY;
	}
	public void update(double dt, double fX, double fY){
		double acceleration_x = fX / this.mass;
		double acceleration_y = fY / this.mass;
		this.xxVel = this.xxVel + acceleration_x * dt;
		this.yyVel = this.yyVel + acceleration_y * dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}
	public void draw(){
		StdDraw.picture(this.xxPos,this.yyPos,"C:/Users/lenovo/cs61b/proj0/images/"+this.imgFileName);
	}
}
