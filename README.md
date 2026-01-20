# Mobiiliohjelmointi-natiiviteknologioilla-week2
## Week2
### mitä tehtiin
  - Tehtävä 2 tehtiin tehtävään 1 (https://github.com/Veeti-1/Mobiiliohjelmointi-natiiviteknologioilla-viikkotehtavat/tree/Week1)
  - Tehtävässä 2 ei käytetty remember:iä vaan viewmodel:ia
## miten compose-tilanhallinta toimii?
  - Compose käyttää Compiler plugin:ia, joka muuttaa @Composable-funktiot UI-koodiksi käännösvaiheessa
  - Compose päivittää realiaikaisesti vain ne osat joiden tila muuttuu.
## Miksi viewmModel on parempi kuin, remember?
  - viewModel tallentaa datan elinkaaren yli esim: käännetään näyttöä.
  - Kun taas remember tallentaa kyseisen composablen elinkaaren ajan.


Youtube-demo: https://youtu.be/tTao0ApTbJ0
