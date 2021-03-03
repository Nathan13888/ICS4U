package quadtree;

public class TestQuadTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuadTree theQT;

		Coord tempCoordA;
		Coord tempCoordB;
		Coord tempCoordPF;

		PointFeature tempFeat;

		tempCoordA = new Coord(0.0, 0.0); // Upper left corner of this main quad
		tempCoordB = new Coord(1000.0, 1000.0); // Lower right corner of this main quad
		theQT = new QuadTree(tempCoordA, tempCoordB, 1); // Max 1 features per any quad

		tempCoordPF = new Coord(125.0, 75.0);
		tempFeat = new PointFeature("PF1", tempCoordPF, "Point Feature #1");
		theQT.addPointFeature(tempFeat);

		tempCoordPF = new Coord(325.0, 275.0);
		tempFeat = new PointFeature("PF2", tempCoordPF, "Point Feature #2");
		theQT.addPointFeature(tempFeat);

		tempCoordPF = new Coord(320.0, 270.0);
		theQT.showFeatsForThisLoc(tempCoordPF);

	}

}
