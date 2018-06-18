package app.iti.driver.contracts

interface HomeContract {
    interface Model {
        fun initModel(presenter: Presenter)
    }
    interface View{

    }
    interface Presenter{
        fun initPresenter(view: View)
    }
}