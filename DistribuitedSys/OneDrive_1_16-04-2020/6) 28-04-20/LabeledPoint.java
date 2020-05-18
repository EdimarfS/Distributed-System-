class LabeledPoint implements Serializable{
	private String label;
	private transient Point2D.Double point; // NotSerializableException
	//...
	
	public LabeledPoint(){}
	
	public LabeledPoint(String l, Point2D.Double p){
		label = l;
		point = point;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.defaultWriteObject();
		out.writeDouble(point.getX());
		out.writeDouble(point.getY());
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
		double x = in.readDouble();
		double y = in.readDouble();
		point = new Point2D.Double(x, y);
	}
}