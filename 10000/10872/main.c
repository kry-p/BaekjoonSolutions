#include <stdio.h>

int main() {
    int input;
    int result = 1;

    scanf("%d", &input);

    for(int i = 1; i <= input; i++) {
        result *= i;
    }

    printf("%d", result);

    return 0;
}