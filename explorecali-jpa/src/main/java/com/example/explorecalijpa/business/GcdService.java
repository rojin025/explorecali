// package com.example.explorecalijpa.business;

// import org.springframework.stereotype.Service;

// @Service
// public class GcdService {

//     /**
//      * cal gcd between 2 nums
//           - 6 and 12
//           - 6

//           - 28 and 21
//           - 7 * 4  and 7 * 3
//           - factors of 28 - [1, 2 ,4 ,7, 28]
//           - factors of 21 - [1, 3 ,7 ,21]

//           - 7

//           uclaedian algo

//           VIM

//           transcition from to java
          
//      * @return
//      */
//     public static long  calculateGcd(long num1 , long num2){
//         long gcd = 1;

//         if(num1 % num2 == 0) return num2;
        
//         if(num2 % num1 == 0) return num1;

//         for(int i = 2; i <= num1; i++ ){
//             if( num1 % i == 0 && num2 % i == 0 ){
//                 gcd = i;
//             }
//         }

//         return gcd;
//     }

//     public static void main(String[] args) {
//         System.out.println( "GCD: " + calculateGcd( 21, 28));
//         System.out.println( "GCD: " + calculateGcd( 6, 12));
//     }

// }
