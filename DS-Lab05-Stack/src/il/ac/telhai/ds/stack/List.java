package il.ac.telhai.ds.stack;
public interface List<T> {

	// In all the methods - the precondition is checked,
	// and a runtime exception is thrown if this condition is not satisfied.

	// Precondition: newElement is not null.
	// Postcondition: Inserts newElement into the list. If the list is not empty,
	// then inserts newElement after the cursor. Otherwise, inserts newElement as
	// the ﬁrst (and only) element in the list. In either case, moves the cursor to
	// newElement.
	public void insert(T newElement);

	// Precondition: NONE
	// Postcondition: Removes the element marked by the cursor from the list. If the
	// resulting list is not empty, then moves the cursor to the element that
	// followed the deleted element. If the deleted element was at the end of the
	// list, then moves the cursor to the beginning of the list. Returns the deleted
	// element, or null if the list was empty.
	public T remove();

	// Precondition: NONE
	// Postcondition: Removes element from the list. Moves the cursor to the element
	// that followed the deleted element. If the deleted element was at the end of
	// the list, then moves the cursor to the beginning of the list. Returns the
	// deleted element, or null if it did not exist in the list.
	// If this element appears several times, removes the first occurrence of it.
	public T remove(T element);

	// Precondition: None.
	// Postcondition: Removes all the elements in a list.
	public void clear();

	// Precondition: List is not empty and newElement is not null.
	// Postcondition: Replaces the element marked by the cursor with newElement. The
	// cursor remains at newElement
	public void replace(T newElement);

	// Precondition: None.
	// Postcondition: Returns true if the list is empty. Otherwise, returns false.
	public boolean isEmpty();

	// Precondition: None.
	// Postcondition: If the list is not empty, then moves the cursor to the
	// beginning of the list. Otherwise, returns false.
	public boolean goToBeginning();

	// Precondition: None.
	// Postcondition: If the list is not empty, then moves the cursor to the end of
	// the list. Otherwise, returns false.
	public boolean goToEnd();

	// Precondition: NONE
	// Postcondition: If the cursor is not at the end of a list, then moves the
	// cursor to the next element and returns it. Otherwise, returns null.
	public T getNext();

	// Precondition: NONE.
	// Postcondition: If the cursor is not at the beginning of a list, then moves
	// the cursor to the preceding element and returns it. Otherwise, returns null.
	public T getPrev();

	// Precondition: NONE.
	// Postcondition: Returns the element marked by the cursor and null if
	// the list is empty.
	public T getCursor();

	// Precondition: NONE
	// Postcondition: If the cursor is not at the end of the list then returns true.
	// Otherwise, returns false.
	// If the list is empty returns false.
	public boolean hasNext();

	// Precondition: NONE.
	// Postcondition: If the cursor is not at the beginning of the list then returns
	// true. Otherwise, returns false.
	// If the list is empty returns false.
	public boolean hasPrev();

}