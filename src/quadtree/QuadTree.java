package quadtree;

import java.util.ArrayList;

public class QuadTree {

	public Coord ulCorner;
	public Coord lrCorner;
	public int maxFeatures; // Max number of features allowed in a quad before splitting the quad
	public ArrayList<PointFeature> features;
	public QuadTree ul;
	public QuadTree ur;
	public QuadTree ll;
	public QuadTree lr;

	public QuadTree(Coord ulCorner, Coord lrCorner, int maxFeatures) {
		this.ulCorner = ulCorner;
		this.lrCorner = lrCorner;
		this.maxFeatures = maxFeatures;
		features = new ArrayList<PointFeature>(this.maxFeatures);
		ul = null;
		ur = null;
		ll = null;
		lr = null;
	}

	public void addPointFeature(PointFeature pfToAdd) {

		/*
		 * If this quad has fewer than maxFeatures features already in it and has no
		 * subquads then add this feature to this quad. Otherwise split this quad into
		 * four subquads and add the feature to the appropriate subquad.
		 */

		if ((features.size() < maxFeatures) && (ul == null) && (ur == null) && (ll == null) && (lr == null)) {
			features.add(pfToAdd);
			return; // Done!
		}

		/*
		 * If we get to here, we don't want to put any more features into this quad. So,
		 * if we haven't already split this quad, we have to split it into four subquads
		 * and then place its features and the received feature into the appropriate
		 * subquads based on their locations.
		 */

		Coord tempCoordA;
		Coord tempCoordB;
		double tempX;
		double tempY;

		// ul subquad
		if (ul == null) {
			tempX = ulCorner.x + ((lrCorner.x - ulCorner.x) / 2.0);
			tempY = ulCorner.y + ((lrCorner.y - ulCorner.y) / 2.0);
			tempCoordB = new Coord(tempX, tempY);
			ul = new QuadTree(ulCorner, tempCoordB, maxFeatures);
		}

		// ur subquad
		if (ur == null) {
			tempX = ulCorner.x + ((lrCorner.x - ulCorner.x) / 2.0);
			tempY = ulCorner.y;
			tempCoordA = new Coord(tempX, tempY);
			tempX = lrCorner.x;
			tempY = ulCorner.y + ((lrCorner.y - ulCorner.y) / 2.0);
			tempCoordB = new Coord(tempX, tempY);
			ur = new QuadTree(tempCoordA, tempCoordB, maxFeatures);
		}

		// ll subquad
		if (ll == null) {
			tempX = ulCorner.x;
			tempY = ulCorner.y + ((lrCorner.y - ulCorner.y) / 2.0);
			tempCoordA = new Coord(tempX, tempY);
			tempX = ulCorner.x + ((lrCorner.x - ulCorner.x) / 2.0);
			tempY = lrCorner.y;
			tempCoordB = new Coord(tempX, tempY);
			ll = new QuadTree(tempCoordA, tempCoordB, maxFeatures);
		}

		// lr subquad
		if (lr == null) {
			tempX = ulCorner.x + ((lrCorner.x - ulCorner.x) / 2.0);
			tempY = ulCorner.y + ((lrCorner.y - ulCorner.y) / 2.0);
			tempCoordA = new Coord(tempX, tempY);
			lr = new QuadTree(tempCoordA, lrCorner, maxFeatures);
		}

		/*
		 * Put each existing point feature for this quad, and then the new point
		 * feature, into the appropriate subquad.
		 */

		PointFeature tempPF;

		features.add(pfToAdd); // Append the new point feature to the list of features.

		int numFeaturesInThisQuad = features.size();
		/*
		 * Do NOT use features.size() in the condition in the for loop below, as its
		 * value decrements by 1 every time we remove a feature from the list!
		 */

		for (int i = 0; i < numFeaturesInThisQuad; i++) {
			/*
			 * Remember that when ArrayList's remove removes an item from a particular
			 * position, it "moves left by 1 spot any items to the right of the removed
			 * item" :-)
			 */
			tempPF = features.remove(0);
			if ((ul.ulCorner.x <= tempPF.loc.x) && (tempPF.loc.x < ul.lrCorner.x) && (ul.ulCorner.y <= tempPF.loc.y)
					&& (tempPF.loc.y < ul.lrCorner.y)) {
				ul.addPointFeature(tempPF);
			} else if ((ur.ulCorner.x <= tempPF.loc.x) && (tempPF.loc.x <= ur.lrCorner.x)
					&& (ur.ulCorner.y <= tempPF.loc.y) && (tempPF.loc.y < ur.lrCorner.y)) {
				ur.addPointFeature(tempPF);
			} else if ((ll.ulCorner.x <= tempPF.loc.x) && (tempPF.loc.x < ll.lrCorner.x)
					&& (ll.ulCorner.y <= tempPF.loc.y) && (tempPF.loc.y <= ll.lrCorner.y)) {
				ll.addPointFeature(tempPF);
			} else if ((lr.ulCorner.x <= tempPF.loc.x) && (tempPF.loc.x <= lr.lrCorner.x)
					&& (lr.ulCorner.y <= tempPF.loc.y) && (tempPF.loc.y <= lr.lrCorner.y)) {
				lr.addPointFeature(tempPF);
			} else {
				System.out.println("ERROR PLACING EXISTING POINT FEATURE WHEN SPLITTING A QUAD");
			}
		}

	} // end addPointFeature

	public void showFeatsForThisLoc(Coord theLoc) {
		/*
		 * Print out the info for each feature that is in the same lowest-level quad as
		 * the received location.
		 */
		PointFeature tempPF;

		// Check whether the input loc is not within the current quad.

		if ((theLoc.x < ulCorner.x) || (theLoc.y < ulCorner.y) || (lrCorner.x < theLoc.x) || (lrCorner.y < theLoc.y)) {
			return; // Input loc is not within current quad.
		}

		// If we get to here then the input loc is within the current quad.

		if ((ul == null) && (ur == null) && (ll == null) && (lr == null)) {
			// At the lowest-level quad for the input loc
			if (features.size() == 0) {
				System.out.println("No features here!");
			} else {
				for (int i = 0; i < features.size(); i++) {
					tempPF = features.get(i);
					System.out.println("  FEATURE ID \n" + tempPF.id + "\n  DESC\n" + tempPF.desc + "\n  AT\n"
							+ tempPF.loc.x + " , " + tempPF.loc.y + "\n");
				}
			}
			return; // Done!
		}

		/*
		 * If we get to here, the current quad has subquads. So, we need to determine
		 * which subquad the input loc is within and then look into that subquad.
		 */

		if ((ul.ulCorner.x <= theLoc.x) && (theLoc.x < ul.lrCorner.x) && (ul.ulCorner.y <= theLoc.y)
				&& (theLoc.y < ul.lrCorner.y)) {
			ul.showFeatsForThisLoc(theLoc);
		} else if ((ur.ulCorner.x <= theLoc.x) && (theLoc.x <= ur.lrCorner.x) && (ur.ulCorner.y <= theLoc.y)
				&& (theLoc.y < ur.lrCorner.y)) {
			ur.showFeatsForThisLoc(theLoc);
		} else if ((ll.ulCorner.x <= theLoc.x) && (theLoc.x < ll.lrCorner.x) && (ll.ulCorner.y <= theLoc.y)
				&& (theLoc.y <= ll.lrCorner.y)) {
			ll.showFeatsForThisLoc(theLoc);
		} else if ((lr.ulCorner.x <= theLoc.x) && (theLoc.x <= lr.lrCorner.x) && (ulCorner.y <= theLoc.y)
				&& (theLoc.y <= lr.lrCorner.y)) {
			lr.showFeatsForThisLoc(theLoc);
		} else {
			System.out.println("showFeatsForThisLoc -- Should never get to this spot!");
		}

	} // end showFeatsForThisLoc

}
