package main

import "fmt"

type Appuntamento struct {
    giorno             int
    oraInizio, oraFine int
}

func main() {

    var gg, h1, h2 int
    agenda := make([]Appuntamento, 0)
    for {
        _, err := fmt.Scan(&gg, &h1, &h2)
        if err != nil {
            break
        }

        a, ok := NewAppuntamento(gg, h1, h2)
        if ok {
            AddAppuntamento(a, &agenda)
        }
    }
    fmt.Println(agenda)
}

func IsValidDay(gg int) bool {
    return 1 <= gg && gg <= 366
}

func IsValidTime(h int) bool {
    return 0 <= h && h <= 24
}

func NewAppuntamento(gg, h1, h2 int) (a Appuntamento, ok bool) {
    if IsValidDay(gg) && IsValidTime(h1) && IsValidTime(h2) && h1 <= h2 {
        a = Appuntamento{gg, h1, h2}
        ok = true
    } else {
        ok = false
    }
    return
}

func AddAppuntamento(a Appuntamento, agenda *[]Appuntamento) bool {
    for _, app := range *agenda {
        if CheckSovrapposizioneAppuntamenti(a, app) {
            return false
        }
    }
    *agenda = append(*agenda, a)
    return true
}

func CheckSovrapposizioneAppuntamenti(a, b Appuntamento) bool {
    if a.giorno != b.giorno {
        return false
    }
    // da qui in poi hanno stesso giorno

    // a inizia in b
    if a.oraInizio >= b.oraInizio && a.oraInizio < b.oraFine {
        return true
    }

    // a finisce in b
    if a.oraFine > b.oraInizio && a.oraFine <= b.oraFine {
        return true
    }

    return false
}
