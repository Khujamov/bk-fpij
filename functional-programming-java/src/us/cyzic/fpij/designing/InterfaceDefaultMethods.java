package us.cyzic.fpij.designing;

public class InterfaceDefaultMethods {

	public interface Fly {
		default void takeOff() { System.out.println("Fly::takeOff"); }
		default void land() { System.out.println("Fly::land"); }
		default void turn() { System.out.println("Fly::turn"); }
		default void cruise() { System.out.println("Fly::cruise"); }
	}
	
	public interface FastFly extends Fly {
		default void takeOff() { System.out.println("FastFly::takeOff"); }
	}
	
	public interface Sail {
		default void turn() { System.out.println("Sail::turn"); }
		default void cruise() { System.out.println("Sail::cruise"); }
	}
	
	public class Vehicle {
		public void turn() { System.out.println("Vehicle::turn"); }
	}
	
	public class SeaPlane extends Vehicle implements FastFly, Sail {
		private int altitude;
		
		public void cruise() {
			System.out.print("SeaPlane::cruise currently cruise like: ");
			if(altitude > 0) {
				FastFly.super.cruise();
			} else {
				Sail.super.cruise();
			}
		}

		public int getAltitude() {
			return altitude;
		}

		public void setAltitude(int altitude) {
			this.altitude = altitude;
		}
		
	}
	
	public void FlyTheSeaPlane() {
		SeaPlane seaPlane = new SeaPlane();
		
		// Will be FastFly because the subtype FastFly takes precedence over the supertype Fly
		seaPlane.takeOff();
		
		// Will be Vehicle because implementations in classes take precedence over all interface defaults
		seaPlane.turn();
		
		// Will be SeaPlane because the inheriting class disambiguates the conflicting implementations
		seaPlane.cruise();
		
		// Will be Fly because that's the only option
		seaPlane.land();
	}
	
	public static void main(String[] args) {
		InterfaceDefaultMethods idm = new InterfaceDefaultMethods();
		idm.FlyTheSeaPlane();
	}

}
