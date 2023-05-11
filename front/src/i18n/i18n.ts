import i18n from "i18next"
import { initReactI18next } from "react-i18next"

const resources = {
  en: {
    translation: {
      id: "ID",
      name: "Name",
      age: "Age",
      gender: "Gender",
    },
  },
  ja: {
    translation: {
      id: "ID",
      name: "名前",
      age: "年齢",
      gender: "性別",
    },
  },
}

export const handleChangeLanguage = (lng: string) => {
  i18n.use(initReactI18next).init({
    resources,
    lng,
    fallbackLng: "en",
    interpolation: {
      escapeValue: false,
    },
  })
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
