package dev.melik.bootcamp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@SpringBootApplication
public class W1q2Application {

	public static void main(String[] args) {
		System.out.println("See tests.");
	}

	/**
	 * Concat two lists.
	 * @param list1
	 * @param list2
	 * @return
	 */
	public List<String> concat(List<String> list1,List<String> list2){
		List<String> list=new ArrayList<>();
		list.addAll(list1);
		list.addAll(list2);
		return list;
	}

	/**
	 * Returns difference group of two lists.
	 * @param list1
	 * @param list2
	 * @return
	 */
	public List<String> difference(List<String> list1, List<String> list2){
		return list1
				.stream()
				.filter(s -> !list2.contains(s))
				.collect(Collectors.toList());
	}

	/**
	 * Generates a list of distinct elements from given list.
	 * @param list
	 * @return
	 */
	public List<String> distinct(List<String> list){
		return list
				.stream()
				.distinct()
				.collect(Collectors.toList());
	}

	/**
	 * Drops first n members of the list
	 * @param list
	 * @param n
	 * @return
	 */
	public List<String> drop(List<String> list, Long n){
		return list
				.stream()
				.skip(n)
				.collect(Collectors.toList());
	}

	/**
	 * Selects given word
	 * @param list
	 * @param word
	 * @return Returns lists of word
	 */
	public List<String> filter(List<String> list, String word){
		return list
				.stream()
				.filter(s -> s.equals(word))
				.collect(Collectors.toList());
	}

	/**
	* Flattens nested lists.
	* */
	public List<String> flatten(List<Object> list){
		List<String> flatList=new ArrayList<>();
		for (Object o : list){
			if (o instanceof List<?>){
				flatList.addAll(flatten((List<Object>) o));
			}else {
				flatList.add(o.toString());
			}

		}
		return flatList;
	}

	/**
	 * Combines list of strings to a single string.
	 **/
	public String reduce(List<String> list){
		StringBuilder builder=new StringBuilder();
		list.forEach(builder::append);
		return builder.toString();
	}

	/**
	 * Groups elements of the list by their first letter.
	 * Case-insensitive
	 * @return A map of first letters and list of strings.
	 */
	public Map<Character,List<String>> groupByFirstLetter(List<String> list){
		return list
				.stream()
				.collect(Collectors.groupingBy(s -> s.toLowerCase().charAt(0)));
	}

	/**
	 * Returns distinct intersection group of two lists.
	 * @param list1 First list
	 * @param list2 Second list
	 */
	public List<String> intersection(List<String> list1,List<String> list2){
		return list1
				.stream()
				.filter(list2::contains)
				.distinct()
				.collect(Collectors.toList());
	}

	/**
	 * Maps 2 digit country codes to country names
	 * @param list List of ISO 3166-1 alpha-2 country codes
	 * @return List of country names in English
	 */
	public List<String> localeMap(List<String> list){
		return list
				.stream()
				.map(s -> new Locale("",s).getDisplayCountry(Locale.ENGLISH))
				.collect(Collectors.toList());
	}

	/**
	 * Reject Human
	 * @param list List of primates
	 * @return Only non-humans
	 */
	public List<String> reject(List<String> list){
		return list
				.stream()
				.filter(Predicate.not("human"::equals))
				.collect(Collectors.toList());
	}

	/**
	 * Returns a slice of given list with index parameters.
	 * @param list
	 * @param from Starting index. Inclusive.
	 * @param to Ending index. Exclusive.
	 * @return Sublist of given list.
	 */
	public List<String> slice(List<String> list,int from,int to){
		return list.subList(from,to);
	}

	/**
	 * Case-insensitive sorting of given list
	 * @param list
	 */
	public List<String> sortLexicographically(List<String> list){
		return list
				.stream()
				.sorted(Comparator.comparing(String::toLowerCase))
				.collect(Collectors.toList());
	}

	public List<String> union(List<String> list1,List<String> list2){
		List<String> list=new ArrayList<String>();
		list.addAll(list1);
		list.addAll(list2);
		return list
				.stream()
				.distinct()
				.collect(Collectors.toList());
	}
}
