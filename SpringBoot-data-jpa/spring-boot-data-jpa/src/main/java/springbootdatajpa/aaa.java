package springbootdatajpa;

import java.util.*;

public class aaa {
    public static void main(String[] args) {
        List<Email> list = new ArrayList();
        list.add(new Email("aaa","bbb",new Date()));
        list.add(new Email("aba","bbc",new Date()));
        list.add(new Email("aaa","bbc",new Date()));
        list.add(new Email("aaa","bbc",new Date()));
        list.add(new Email("aba","bbc",new Date()));
        list.add(new Email("aaa","bbc",new Date()));
        list.add(new Email("aaa","bbb",new Date()));
        System.out.println(list.size());
        List<Email> emails = new ArrayList<>();
        Go:
        for(int i=0; i<list.size()-1; i++) {
            for (int j=i+1; j<list.size(); j++) {
                if (list.get(i).getTitle() == list.get(j).getTitle()) {
                    if (list.get(i).getName() == list.get(j).getName()) {
                        if (list.get(i).getDate().getTime() >= list.get(j).getDate().getTime()) {
                            /*list.remove(i);
                            i = i - 1;*/
                            emails.add(list.get(i));
                            continue Go;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        list.removeAll(emails);
        for (int k=0; k<list.size(); k++) {
            System.out.println(list.get(k));
        }

    }
}
