import React, { useState } from "react"
import { Container, Button, Table } from "semantic-ui-react"
import "semantic-ui-css/semantic.min.css"
import { useTranslation } from "react-i18next"
import axios from "axios"

interface User {
  name: string
  age: number
  gender: string
}

const UserTable: React.FC = () => {
  const { t } = useTranslation()

  const [users, setUsers] = useState<User[]>([])

  const handleDownloadCSV = async () => {
    const response = await axios.get("/api/users")
    const usersData: User[] = response.data

    let csvContent = `"${t("name")}", "${t("age")}", "${t("gender")}"\n"${t(
      "name-en"
    )}", "${t("age-en")}", "${t("gender-en")}"\n`

    usersData.forEach((user) => {
      csvContent += `"${user.name}", "${user.age}", "${user.gender}"\n`
    })

    const encodedUri = encodeURI(`data:text/csv;charset=utf-8,${csvContent}`)
    const link = document.createElement("a")
    link.setAttribute("href", encodedUri)
    link.setAttribute("download", "users.csv")
    document.body.appendChild(link)
    link.click()
  }

  return (
    <Container>
      <Button primary onClick={handleDownloadCSV}>
        {t("download-csv")}
      </Button>
      <Table celled>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>{t("name")}</Table.HeaderCell>
            <Table.HeaderCell>{t("age")}</Table.HeaderCell>
            <Table.HeaderCell>{t("gender")}</Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {users.map((user) => (
            <Table.Row>
              <Table.Cell>{user.name}</Table.Cell>
              <Table.Cell>{user.age}</Table.Cell>
              <Table.Cell>{user.gender}</Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
      </Table>
    </Container>
  )
}

export default UserTable
