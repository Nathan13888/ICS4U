package hashtable;

import java.util.ArrayList;

public class MyHashTable {

	// ATTRIBUTES

	public ArrayList<StudentInfo>[] buckets;

	// CONSTRUCTOR

	@SuppressWarnings("unchecked")
	public MyHashTable(int howManyBuckets) { // assuming howManyBuckets is vali
		this.buckets = new ArrayList[howManyBuckets];

		// For each element in the array, instantiate its ArrayList.
		for (int i = 0; i < howManyBuckets; i++) {
			buckets[i] = new ArrayList<StudentInfo>();
		}
	}

	// METHODS

	public int calcBucket(int studentNumber) {
		return (studentNumber < 0) ? (calcBucket(studentNumber + buckets.length)) : (studentNumber % buckets.length);
	}

	public void addToTable(StudentInfo theStudent) { // Add the student referenced by theStudent to the hash table.
		if (theStudent != null) {
			int targetBucket = calcBucket(theStudent.studentNumber);
			// Append that student to the ArrayList for that bucket.
			@SuppressWarnings("unused")
			boolean addStatus = buckets[targetBucket].add(theStudent);
		}

	}

	public StudentInfo removeFromTable(int studentNumber) {
		// Remove that student from the hash table and return the reference value for
		// that student.
		if (studentNumber >= 0) {
			ArrayList<StudentInfo> bucket = buckets[calcBucket(studentNumber)];
			for (StudentInfo student : bucket) {
				if (student.studentNumber == studentNumber) {
					bucket.remove(student);
					return student;
				}
			}
		}
		// Return null if that student isn't in the table.
		return null;
	}

	public StudentInfo getFromTable(int studentNumber) {
		// Return the reference value for that student, return null if student isn't in
		// the table.
		if (studentNumber >= 0) {
			for (StudentInfo student : buckets[calcBucket(studentNumber)])
				if (student.studentNumber == studentNumber)
					return student;
		}
		return null;
	}

	public boolean isInTable(int studentNumber) {
		// Return true if that student is in the hash table, false otherwise.
		for (StudentInfo student : buckets[calcBucket(studentNumber)])
			if (student.studentNumber == studentNumber)
				return true;
		return false;
	}

	public void displayTable() {
		// Walk through the buckets and display the items in each bucket's ArrayList.
		StudentInfo currentStudent;
		for (int i = 0; i < buckets.length; i++) {
			System.out.println("Contents for Bucket #" + i);
			// Display the items in this bucket's ArrayList.
			if (buckets[i].size() == 0) {
				System.out.println("\tNo items for this bucket!");
			} else {
				// Get the info for each item in this ArrayList.
				for (int j = 0; j < buckets[i].size(); j++) {
					currentStudent = buckets[i].get(j);
					System.out.println("\t" + currentStudent.studentNumber + " " + currentStudent.firstName + " "
							+ currentStudent.lastName);
				}
			}
		}
		System.out.println();
	}

}
