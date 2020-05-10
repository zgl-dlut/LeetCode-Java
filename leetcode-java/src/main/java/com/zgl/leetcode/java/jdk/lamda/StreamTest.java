package com.zgl.leetcode.java.jdk.lamda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zgl
 * @date 2020/5/10 下午8:58
 */
public class StreamTest {
	private List<Student> students = new ArrayList<Student>() {
		{
			add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
			add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
			add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
			add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
			add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
			add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
			add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
			add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
			add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
			add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
		}
	};

	/**
	 * filter
	 */
	List<Student> whuStudents = students.stream()
			.filter(student -> "武汉大学".equals(student.getSchool()))
			.collect(Collectors.toList());

	/**
	 * limit
	 * limit操作也类似于SQL语句中的LIMIT关键字，不过相对功能较弱，limit返回包含前n个元素的流，当集合大小小于n时，则返回实际长度，比如下面的例子返回前两个专业为土木工程专业的学生：
	 */
	List<Student> civilStudents = students.stream()
			.filter(student -> "土木工程".equals(student.getMajor())).limit(2)
			.collect(Collectors.toList());

	/**
	 * skip
	 *
	 * skip操作与limit操作相反，如同其字面意思一样，是跳过前n个元素，比如我们希望找出排序在2之后的土木工程专业的学生，那么可以实现为：
	 */
	List<Student> civilStudents2 = students.stream()
			.filter(student -> "土木工程".equals(student.getMajor()))
			.skip(2)
			.collect(Collectors.toList());

	/**
	 * sorted
	 */
	List<Student> sortedCivilStudents = students.stream()
			.filter(student -> "土木工程".equals(student.getMajor())).sorted(Comparator.comparingInt(Student::getAge))
			.limit(2)
			.collect(Collectors.toList());
	/**
	 * map
	 *
	 * 举例说明，假设我们希望筛选出所有专业为计算机科学的学生姓名，那么我们可以在filter筛选的基础之上，通过map将学生实体映射成为学生姓名字符串，具体实现如下
	 */
	List<String> names = students.stream()
			.filter(student -> "计算机科学".equals(student.getMajor()))
			.map(Student::getName).collect(Collectors.toList());
	/**
	 * count
	 *
	 */
	long count = students.stream().collect(Collectors.counting());
	// 进一步简化
	long count1 = students.stream().count();
	/**
	 * [j, a, v, a, 8]
	 * [i, s]
	 * [e, a, s, y]
	 * [t, o]
	 * [u, s, e]
	 */
	//进一步简化2
	long count2 = (long) students.size();
	/**
	 * 例2：求年龄的最大值和最小值
	 */

	// 求最大年龄
	Optional<Student> olderStudent = students.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));
	// 进一步简化
	Optional<Student> olderStudent2 = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
	// 求最小年龄
	Optional<Student> olderStudent3 = students.stream().min(Comparator.comparing(Student::getAge));
	/**
	 * 例3：求年龄总和
	 */

	int totalAge4 = students.stream().collect(Collectors.summingInt(Student::getAge));
	/**
	 * 对应的还有summingLong、summingDouble。
	 *
	 * 	例4：求年龄的平均值
	 */

	double avgAge = students.stream().collect(Collectors.averagingInt(Student::getAge));
	/**
	 * 对应的还有averagingLong、averagingDouble。
	 *
	 * 	例5：一次性得到元素个数、总和、均值、最大值、最小值
	 */

	IntSummaryStatistics statistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
	/**
	 * 例6：字符串拼接
	 */

	String names1 = students.stream().map(Student::getName).collect(Collectors.joining());
	// 输出：孔明伯约玄德云长翼德元直奉孝仲谋鲁肃丁奉
	String names2 = students.stream().map(Student::getName).collect(Collectors.joining(", "));
	/**
	 * 分组
	 *
	 * 	在数据库操作中，我们可以通过GROUP BY关键字对查询到的数据进行分组，java8的流式处理也为我们提供了这样的功能Collectors.groupingBy来操作集合。比如我们可以按学校对上面的学生进行分组：
	 */

	Map<String, List<Student>> groups = students.stream().collect(Collectors.groupingBy(Student::getSchool));
	/**
	 * 输出：
	 *
	 * 	IntSummaryStatistics{count=10, sum=220, min=20, average=22.000000, max=24}
	 * 	对应的还有summarizingLong、summarizingDouble。
	 */
	/**
	 * groupingBy接收一个分类器Function<? super T, ? extends K> classifier，我们可以自定义分类器来实现需要的分类效果。
	 *
	 * 	上面演示的是一级分组，我们还可以定义多个分类器实现 多级分组，比如我们希望在按学校分组的基础之上再按照专业进行分组，实现如下：
	 */

	Map<String, Map<String, List<Student>>> groups2 = students.stream().collect(
			Collectors.groupingBy(Student::getSchool,  // 一级分组，按学校
					Collectors.groupingBy(Student::getMajor)));  // 二级分组，按专业
	Map<String, Long> groups1 = students.stream().collect(Collectors.groupingBy(Student::getSchool, Collectors.counting()));
// 输出：孔明, 伯约, 玄德, 云长, 翼德, 元直, 奉孝, 仲谋, 鲁肃, 丁奉
	/**
	 * 分区
	 *
	 * 	分区可以看做是分组的一种特殊情况，在分区中key只有两种情况：true或false，目的是将待分区集合按照条件一分为二，java8的流式处理利用collectors.partitioningBy()方法实现分区，该方法接收一个谓词，例如我们希望将学生分为武大学生和非武大学生，那么可以实现如下：
	 */

	Map<Boolean, List<Student>> partition = students.stream().collect(Collectors.partitioningBy(student -> "武汉大学".equals(student.getSchool())));
	/**
	 * flatMap
	 *
	 * flatMap与map的区别在于 flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流 。举例说明，假设我们有一个字符串数组String[] strs = {"java8", "is", "easy", "to", "use"};，我们希望输出构成这一数组的所有非重复字符，那么我们可能首先会想到如下实现：
	 */
	private String[] strs = {"java8", "is", "easy", "to", "use"};
	//实际上在groupingBy的第二个参数不是只能传递groupingBy，还可以传递任意Collector类型，比如我们可以传递一个Collector.counting，用以统计每个组的个数：
	List<String[]> distinctStrs = Arrays.stream(strs)
			.map(str -> str.split(""))  // 映射成为Stream<String[]>
			.distinct()
			.collect(Collectors.toList());
	//如果我们不添加第二个参数，则编译器会默认帮我们添加一个Collectors.toList()。
	/**
	 * flatMap
	 * distinct只有对于一个包含多个字符的流进行操作才能达到我们的目的，即对Stream进行操作。此时flatMap就可以达到我们的目的：
	 */
	List<String> distinctStrs1 = Arrays.stream(strs)
			.map(str -> str.split(""))  // 映射成为Stream<String[]>
			.flatMap(Arrays::stream)  // 扁平化为Stream<String>
			//.distinct()
			.collect(Collectors.toList());

	public static void main(String[] args) {
		StreamTest streamTest = new StreamTest();
		System.out.println(streamTest.groups1);
		System.out.println(streamTest.groups2);
	}


}

class Student {

	/** 学号 */
	private long id;

	private String name;

	private int age;

	/** 年级 */
	private int grade;

	/** 专业 */
	private String major;

	/** 学校 */
	private String school;

	public Student(long id, String name, int age, int grade, String major, String school) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.major = major;
		this.school = school;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}