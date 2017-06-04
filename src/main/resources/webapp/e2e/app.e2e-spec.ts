import { EgTareasAngular2Page } from './app.po';

describe('eg-tareas-angular2 App', () => {
  let page: EgTareasAngular2Page;

  beforeEach(() => {
    page = new EgTareasAngular2Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
