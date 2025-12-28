public class ListTestInteger extends ListTest<Integer>{
	@Override
	int i=0;
	public Integer getParameterInstance() {
		//TODO add your implementation
		return Integer.valueOf(i++)
	}

}
