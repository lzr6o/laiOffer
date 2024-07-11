#include <stdio.h>
#include <string.h>

void getStr(char *str, char *fir, char *sec)
{
    strncpy(fir, str + 7, 3);
    printf("First: %s ", fir);
    strncpy(sec, str + 11, 5);
    printf("Second: %s ", sec);
}

int main()
{
    printf("Hello World!");
    char word[] = "Geeks_for_Geeks";
    char *str = word;
    char *fir;
    char *sec;
    getStr(str, fir, sec);

    printf("First: %s ", fir);
    printf("Second: %s ", sec);
    return 0;
}