Date d = new Date(1, 1, 2020);
Date[] dates = new Date[3];
// filling up dates
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("date.dat"));

out.writeObject(d);
out.writeObject(dates) // you can also write an array of objects
out.close();

ObjectInputStream in = new ObjectInputStream(new FileInputStream("date.dat"));
Date recovered = (Date)in.readObject();
Date[] rec_dates = (Date[])in.readObject(); // if an array is read, you must cast back to an array










java.io.Serializable;

public interface Serializable{
	//empty interface
}

class SomeType implements Serializable{
	Date d = new Date(1, 1, 2020);
}

ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("date.dat"));
SomeType o = SomeType();

out.writeObject(o);
out.close();






transient




// to be defined in your class that requires custom serialization
private void writeObject(ObjectOutputStream) throws IOException
private void readObject(ObjectInputStream) throws IOException, ClassNotFoundException






















