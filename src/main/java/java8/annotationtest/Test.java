package java8.annotationtest;

@Annot("a1")
@Annot("a2")
public class Test {
	public static void main(String[] args) {
		Annots annots1 = Test.class.getAnnotation(Annots.class);
		System.out.println(annots1.value()[0] + "," + annots1.value()[1]);
		// 输出: @Annot(value=a1),@Annot(value=a2)
		Annot[] annots2 = Test.class.getAnnotationsByType(Annot.class);
		System.out.println(annots2[0] + "," + annots2[1]);
		// 输出: @Annot(value=a1),@Annot(value=a2)
	}
}
