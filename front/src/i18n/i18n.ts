import i18n from "i18next"
import { initReactI18next } from "react-i18next"

const resources = {
  en: {
    translation: {
      name: "Name",
      age: "Age",
      gender: "Gender",
    },
  },
  ja: {
    translation: {
      name: "名前",
      age: "年齢",
      gender: "性別",
    },
  },
}

i18n.use(initReactI18next).init({
  resources,
  lng: "en",
  fallbackLng: "en",
  interpolation: {
    escapeValue: false,
  },
})

export default i18n
