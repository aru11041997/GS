package org.example.fraction;

public class Fraction {
    public int[] addFraction(int[] f1, int[] f2) {
        int[] res = new int[2];
        int d = 0;
        int n = 0;
        if(f1[1]==f2[1]) {
            d = f1[1];
            n = f1[0] + f2[0];
        } else {
            d = f1[1]*f2[1];
            n = (f1[0]*f2[1])+(f1[1]*f2[0]);
        }
        int x = 0;
        if(n > d)
            x = n;
        else
            x = d;
        for(int i = 1 ; i <= x ; i++)
        {
            if(n%i == 0 && d%i == 0)
            {
                n = n/i;
                d = d/i;
            }
        }
        res[0] = n;
        res[1] = d;
        return res;
    }
}
