package main

import (
    "fmt"
    "io/ioutil"
    "math/rand"
    "os"
    "time"
)

func main() {
    file, err := ioutil.ReadFile("script.txt")
    if err != nil {
        fmt.Println("Could not open file")
        os.Exit(-1)
    }

    energyConverterText := string(file)
    for i := 0; i < 2; i++ {
        for _, c := range energyConverterText {
            fmt.Print(string(c))
            time.Sleep(20 * time.Millisecond)
        }
    }

    count := 0
    chars := "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    rand.Seed(time.Now().UTC().UnixNano())

    for {
        fmt.Print(string(chars[rand.Intn(len(chars))]))
        if count % 80 == 0 {
            fmt.Print("\n")
        }

        time.Sleep(10 * time.Millisecond)
        count++
    }
}
