import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if (getal <=0){
            throw new IllegalArgumentException("getal kan niet negatief zijn");
        }
        else if (getal<=2){
            return 1;
        }
        else {
            return fibonacci(getal-2)+fibonacci(getal-1);
        }
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        if (getal<=0){
            getal=getal* -1;
        }
        if (getal<=9){
            return getal;
        }
        else {
            String getalToString = getal+"";
            return somVanCijfers(parseInt(getalToString.substring(0,1)))+somVanCijfers(parseInt(getalToString.substring(1)));
        }
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Sting is leeg");
        }
        if (s.length()<=1){
            return s;
        }
        else {
            return s.substring(s.length()-1)+keerOm(s.substring(0,s.length()-1));
        }
    }

    //oefening 4: countX

    public static int countX(String s) {
        if (s == null) {
            throw new IllegalArgumentException("");
        }
        if (s.isBlank()) {
            return 0;
        }
        if (s.substring(0, 1).contains("x")) {
            return 1 + countX(s.substring(1));
        }
        else {
            return countX(s.substring(1));
        }
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s == null) {
            throw new IllegalArgumentException("");
        }
        if (s.isBlank()) {
            return 0;
        }
        if (s.length() <= 1) {
            return 0;
        }
        if (s.length() == 2) {
            if (s.equals("hi")) {
                return 1;
            } else {
                return 0;
            }
        }
        if (s.startsWith("hi")) {
            return 1 + countHi(s.substring(1));
        }
        else {
            return countHi(s.substring(1));
        }
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s==null){
            throw new IllegalArgumentException("");
        }
        if (s.length()<=0){
            return "";
        }
        if (s.charAt(0) == 'x'){
            return "y" + changeXY(s.substring(1));
        }
        else{
            return s.charAt(0) + changeXY(s.substring(1));
        }
    }

    // oefening 7
    public static String changePi(String s) {
        if (s==null){
            throw new IllegalArgumentException("");
        }
        if (s.length()<2){
            return s;
        }
        if (s.startsWith("pi")){
            return "3.14"+changePi(s.substring(2));
        }
        else {
            return s.charAt(0)+changePi(s.substring(1));
        }
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal<=0){
            throw new IllegalArgumentException("");
        }
        if (getal%2!=0){
            return 0;
        }
        else {
            return 1+tweelog(getal/2);
        }
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if (lijst==null||lijst.isEmpty()){
            throw new IllegalArgumentException("");
        }
        if (lijst.size()==1){
            return lijst.get(0);
        }
        if (lijst.get(0)<lijst.get(1)){
            lijst.remove(0);
        }
        else {
            lijst.remove(1);
        }
        return findMaximum(lijst);
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        if (string==null){
            throw new IllegalArgumentException("");
        }
        return null;
    }

    // oefening 11;
    public static int aantalKaarten(int n){
        if (n<=0){
            throw new IllegalArgumentException("");
        }
        if (n==1){
            return 2;
        }
        else{
            return n*2+n-1+aantalKaarten(n-1);
        }
    }

}