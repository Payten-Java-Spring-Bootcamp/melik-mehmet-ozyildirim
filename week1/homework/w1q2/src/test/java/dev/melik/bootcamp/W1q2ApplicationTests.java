package dev.melik.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Map;

@SpringBootTest
class W1q2ApplicationTests {

	private final W1q2Application w1q2Application=new W1q2Application();

	@Test
	void concatTest(){
		List<String> list1=List.of("elma","elma","armut");
		List<String> list2=List.of("karpuz","çilek","çilek");
		Assertions.assertEquals(List.of("elma","elma","armut","karpuz","çilek","çilek"),w1q2Application.concat(list1,list2));
	}
	@Test
	void differenceTest(){
		List<String> list1=List.of("elma","elma","armut");
		List<String> list2=List.of("karpuz","çilek","elma");
		Assertions.assertEquals(List.of("armut"),w1q2Application.difference(list1,list2));
	}

	@Test
	void distinctTest(){
		List<String> list=List.of("elma","elma","armut","armut","armut","kiraz");
		Assertions.assertEquals(List.of("elma","armut","kiraz"),w1q2Application.distinct(list));
	}

	@Test
	void dropOrSkipTest(){
		List<String> list=List.of("elma","elma","armut","armut","armut","kiraz");
		Assertions.assertEquals(List.of("elma","armut","armut","armut","kiraz"),w1q2Application.drop(list,1L));
	}

	@Test
	void filterTest(){
		List<String> list=List.of("elma","elma","armut","armut","armut","kiraz");
		Assertions.assertEquals(List.of("elma","elma"),w1q2Application.filter(list,"elma"));
	}

	@Test
	void flattenTest(){
		List<Object> list=List.of("Ahmet","Ali",List.of("Ayşe","Rıza",List.of("Mehmet")));
		Assertions.assertEquals(List.of("Ahmet","Ali","Ayşe","Rıza","Mehmet"),w1q2Application.flatten(list));
	}

	@Test
	void reduceTest(){
		List<String> list=List.of("a","b","c","d");
		Assertions.assertEquals("abcd",w1q2Application.reduce(list));
	}

	@Test
	void groupByFirstLetterTest(){
		List<String> list=List.of("ahmet","Ali","Ayşe","Rıza","Mehmet","Mustafa");
		Map<Character, List<String>> letterMap=w1q2Application.groupByFirstLetter(list);
		Assertions.assertEquals(List.of("ahmet","Ali","Ayşe"),letterMap.get('a'));
		Assertions.assertEquals(List.of("Rıza"),letterMap.get('r'));
		Assertions.assertEquals(List.of("Mehmet","Mustafa"),letterMap.get('m'));
	}

	@Test
	void intersectionTest(){
		List<String> list1=List.of("elma","elma","armut","armut","armut","kiraz");
		List<String> list2=List.of("karpuz","çilek","çilek","elma","elma","armut");
		Assertions.assertEquals(List.of("elma","armut"),w1q2Application.intersection(list1,list2));
	}

	@Test
	void localeMapTest(){
		List<String> countryCode=List.of("tr","ru","es");
		Assertions.assertEquals(List.of("Turkey","Russia","Spain"),w1q2Application.localeMap(countryCode));
	}

	@Test
	void rejectHumanityTest(){
		List<String> homies=List.of("monkey","human","human","gorilla");
		Assertions.assertEquals(List.of("monkey","gorilla"),w1q2Application.reject(homies),"All my homies reject humanity.");
	}

	@Test
	void sliceTest(){
		List<String> pizza=List.of("Slice 1","Slice 2","Slice 3", "Slice 4", "Slice 5", "Slice 6");
		Assertions.assertEquals(List.of("Slice 1","Slice 2"),w1q2Application.slice(pizza,0,2));
	}

	@Test
	void sortTest(){
		List<String> list=List.of("ahmet","Ali","Ayşe","Rıza","Mehmet","Mustafa");
		Assertions.assertEquals(List.of("ahmet","Ali","Ayşe","Mehmet","Mustafa","Rıza"),w1q2Application.sortLexicographically(list));
	}

	@Test
	void unionTest(){
		List<String> list1=List.of("elma","elma","armut","armut","armut","kiraz");
		List<String> list2=List.of("karpuz","çilek","çilek","elma","elma","armut");
		Assertions.assertEquals(List.of("elma","armut","kiraz","karpuz","çilek"),w1q2Application.union(list1,list2));
	}
}
