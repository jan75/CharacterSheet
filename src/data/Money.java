package data;

public class Money {
	int cp;
	int sp;
	int ep;
	int gp;
	int pp;
	public Money(int cp, int sp, int ep, int gp, int pp){
		this.cp=cp;
		this.sp=sp;
		this.ep=ep;
		this.gp=gp;
		this.pp=pp;
	}
	
	public Money updateMoney(int cp, int sp, int ep, int gp, int pp){
		this.cp+=cp;
		this.sp+=sp;
		this.ep+=ep;
		this.gp+=gp;
		this.pp+=pp;
		while(this.cp>10){
			this.cp-=10;
			this.sp+=1;
		}
		while(this.sp>5){
			this.sp-=5;
			this.ep+=1;
		}
		while(this.ep>2){
			this.ep-=2;
			this.gp+=1;
		}
		while(this.gp>10){
			this.gp-=10;
			this.pp+=1;
		}
		return this;
	}

	public int getCopper() {
		// TODO Auto-generated method stub
		return cp;
	}

	public int Silver() {
		// TODO Auto-generated method stub
		return sp;
	}

	public int getEterium() {
		// TODO Auto-generated method stub
		return ep;
	}

	public int getGold() {
		// TODO Auto-generated method stub
		return gp;
	}

	public int getPlatinium() {
		// TODO Auto-generated method stub
		return pp;
	}
}
