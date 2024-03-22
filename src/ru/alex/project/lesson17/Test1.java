package ru.alex.project.lesson17;

import ru.alex.project.lesson17.ClientAuthData;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        HashMap<String, Integer> customers = new HashMap<>();
        customers.put("Moscow", 790);
        customers.put("Rostov", 300);
        customers.put("Novgorod", 210);
        System.out.println(customers.size());
        customers.put("Rostov", 290);
        customers.put(null, 1000);
        customers.put("Samara", 530);
        customers.put("SPb", null);
        System.out.println(customers.size());
        customers.remove(null);
        customers.remove(null);
        customers.remove("SPb");

        customers.remove("Rostov", 300);// Вернет false
        customers.remove("SPb", null);// false

        customers.replace("Samara", 940);
        customers.replace("Samara", 940, 944);

        System.out.println(customers.get("Moscow"));
        System.out.println(customers.get("SPb"));

        Integer spbValue = customers.getOrDefault("SPb", -1);
          if(spbValue == -1){
            System.out.println("Информация отсутствует");
        } else {
            System.out.println(spbValue);
        }

        Collection<Integer> values = customers.values();
        Set<String> keys = customers.keySet();
        Set<Map.Entry<String, Integer>> pairs = customers.entrySet();

        for (Map.Entry<String, Integer> pair: pairs){
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }
        System.out.println(abc(customers, 700));



        EnumMap<ClientAuthData.Role, List<ClientAuthData>> clientByRole =
                new EnumMap<>(ClientAuthData.Role.class);
        clientByRole.put(ClientAuthData.Role.USER, new ArrayList<>());
        ClientAuthData client01 =
                new ClientAuthData("qwe", "123", ClientAuthData.Role.ADMIN);
        ClientAuthData client02 =
                new ClientAuthData("asd", "234", ClientAuthData.Role.ADMIN);
        ArrayList<ClientAuthData> clientList = new ArrayList<>();
        clientList.add(client01);
        clientList.add(client02);
        clientByRole.put(ClientAuthData.Role.ADMIN, clientList);
        ClientAuthData client03 =
                new ClientAuthData("user01", "123", ClientAuthData.Role.USER);
        clientByRole.get(ClientAuthData.Role.USER).add(client03);



    }
    public static void addClintData(EnumMap<ClientAuthData.Role, List<ClientAuthData>> clientByRole, ClientAuthData clientAuthData){
        if(clientByRole == null || clientAuthData == null || clientAuthData.getRole() == null){

            clientByRole.get(clientAuthData.getRole()).add(clientAuthData);

            // Если нет списка по ключу
            clientByRole.put(clientAuthData.getRole(), clientByRole.getOrDefault(clientAuthData.getRole(), new ArrayList<>()));
            // тоже самое расписано
            if(!clientByRole.containsKey(clientAuthData.getRole())){
                ArrayList<ClientAuthData> list = new ArrayList<>();
                list.add(clientAuthData);
                clientByRole.put(clientAuthData.getRole(), list);
            }
        }
    }


    public static ArrayList<String> abc(HashMap<String, Integer> map, int max){
        Set<Map.Entry<String, Integer>> pairs = map.entrySet();
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> pair: pairs){
            if(pair.getValue() < max){
                list.add(pair.getKey());
            }
        }
        return list;
    }

    public static Map<String, String> aaa(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map){
        Map<String, String> map1 = new HashMap<>();
        for(int i = 0; i < map.get(ClientAuthData.Role.USER).size(); i++){

            map1.put(map.get(ClientAuthData.Role.USER).get(i).getUserName(), map.get(ClientAuthData.Role.USER).get(i).getPassword());
        }
        return map1;
    }

}
