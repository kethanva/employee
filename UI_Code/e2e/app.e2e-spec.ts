import { AppPage } from './app.po';

describe('employee-app App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('Should display welcome message but', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to Employee UI App!');
  });
});
